package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        val fb = Firebase.firestore
        val botaoAvancar = findViewById<Button>(R.id.cadastrarConsulta)
        val cpfCampo = findViewById<EditText>(R.id.CPFView)

        botaoAvancar.setOnClickListener{
            if(cpfCampo.text.toString().trim().length != 11) {
                Toast.makeText(this, "Digite um CPF válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(this, "Checando CPF...", Toast.LENGTH_SHORT).show()

            // atualizando todos os hospitais no SpinnerHospitalData
            fb.collection("hospitais").get()
                .addOnSuccessListener { docs ->
                    for (doc in docs.documents){
                        val nome = doc.get("nome").toString()
                        val url = doc.get("url").toString()
                        SpinnerHospitalData.hospitalNames.add(nome)
                        SpinnerHospitalData.hospitalMap += (nome to url)
                    }
                }

            //Toast.makeText(this, cpfCampo.text.toString(), Toast.LENGTH_SHORT).show()
            fb.collection("usuarios").get()
                .addOnSuccessListener { docs ->
                    var idFound = ""
                    var crm = ""
                    for (doc in docs){
                        if(doc.get("cpf")==cpfCampo.text.toString()){
                            idFound = doc.id
                            crm = doc.get("crm").toString()
                            break
                        }
                    }
                    if (idFound == "") {
                        val intent = Intent(this, Primeiro_Acesso1::class.java)
                        intent.putExtra("cpf", cpfCampo.text.toString())
                        intent.putExtra("crm", crm)
                        startActivity(intent)
                    } else {
                        val intent = Intent(this, senha_acesso::class.java)
                        intent.putExtra("id", idFound)
                        intent.putExtra("crm", crm)
                        Log.d("TAG", "crm: " + crm)

                        startActivity(intent)
                    }

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

