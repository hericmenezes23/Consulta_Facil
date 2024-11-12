package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Primeiro_Acesso3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_acesso3)
        val cpfConfirma = findViewById<TextView>(R.id.NovoCpfView)
        val nomeConfirma = findViewById<TextView>(R.id.NovoNomeView)
        val botaoSim = findViewById<Button>(R.id.botao_sim)
        val botaoNao = findViewById<Button>(R.id.botao_nao)
        val fb = Firebase.firestore
        val nomeNovo = intent.getStringExtra("nome")
        val cpfNovo = intent.getStringExtra("cpf")
        val senhaNovo = intent.getStringExtra("senha")
        val crmNovo = intent.getStringExtra("crm")

        Log.d("NOME", nomeNovo.toString())
        Log.d("CPF", cpfNovo.toString())
        Log.d("CRM", crmNovo.toString())


        cpfConfirma.text = "CPF: " + cpfNovo.toString()
        nomeConfirma.text = "NOME: " + nomeNovo.toString()

        botaoSim.setOnClickListener{
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)

            val docData = hashMapOf(
                "user" to nomeNovo.toString(),
                "cpf" to cpfNovo.toString(),
                "crm" to crmNovo.toString(),
                "password" to senhaNovo.toString()
            )
            // Salva no banco
            fb.collection("usuarios").document().set(docData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                }.addOnFailureListener {
                    Toast.makeText(this, "Erro ao salvar", Toast.LENGTH_SHORT).show();
                }
        }
        botaoNao.setOnClickListener{
            val intent = Intent(this, Primeiro_Acesso1::class.java)
            startActivity(intent)
        }
    }
}