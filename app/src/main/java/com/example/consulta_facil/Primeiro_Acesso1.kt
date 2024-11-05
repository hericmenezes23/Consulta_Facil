package com.example.consulta_facil

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Primeiro_Acesso1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_acesso2)

        var fb = Firebase.firestore
        val botaoAvancar = findViewById<Button>(R.id.cadastrar)
        val cpfCampo = findViewById<EditText>(R.id.CPFView)

        botaoAvancar.setOnClickListener{
            //Toast.makeText(this, cpfCampo.text.toString(), Toast.LENGTH_SHORT).show()
            fb.collection("usuarios").get()
                .addOnSuccessListener { docs ->
                    Toast.makeText(this, "sucess", Toast.LENGTH_SHORT).show()

                    for (doc in docs){
                        if(doc.get("user")==cpfCampo.text.toString()){
                            Toast.makeText(
                                this, "Usuario ja existe",
                                Toast.LENGTH_LONG
                            ).show()
                            break
                        }

                    }

                }.addOnFailureListener { exception ->
                    Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show()
                    println(exception.message)
                    println(exception.stackTrace)
                    println(exception.localizedMessage)
                    println(exception.cause)
                }

//            if(cpfCampo.getText().toString().trim().length == 11){
//                val intent = Intent(this, Primeiro_Acesso2::class.java)
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, "Digite um CPF válido", Toast.LENGTH_SHORT).show();
//            }
        }
    }
}