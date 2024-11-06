package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class CPF_Acesso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cpf_acesso)

        var fb = Firebase.firestore
        val botaoAvancar = findViewById<Button>(R.id.cadastrar)
        val cpfCampo = findViewById<EditText>(R.id.CPFView)
        var userData = DadosUsuario()

        botaoAvancar.setOnClickListener{
            if(cpfCampo.getText().toString().trim().length != 11) {
                Toast.makeText(this, "Digite um CPF válido", Toast.LENGTH_SHORT).show();
                return@setOnClickListener
            }
            Toast.makeText(this, "Checando CPF...", Toast.LENGTH_SHORT).show()

            //Toast.makeText(this, cpfCampo.text.toString(), Toast.LENGTH_SHORT).show()
            fb.collection("usuarios").get()
                .addOnSuccessListener { docs ->
                    for (doc in docs){
                        if(doc.get("cpf")==cpfCampo.text.toString()){
                            userData.id = doc.id
                            userData.cpf = doc.get("cpf").toString()
                            val intent = Intent(this, senha_acesso::class.java)
                            intent.putExtra("userData", userData)
                            startActivity(intent)
                            break
                        }
                    }
                    val intent = Intent(this, Primeiro_Acesso1::class.java)
                    intent.putExtra("userData", userData)
                    startActivity(intent)

                }.addOnFailureListener { exception ->
                    Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show()
                    println(exception.message)
                    println(exception.stackTrace)
                    println(exception.localizedMessage)
                    println(exception.cause)
                }
        }
    }
}

private fun Intent.putExtra(s: String, data: Map<String, Any>) {

}
