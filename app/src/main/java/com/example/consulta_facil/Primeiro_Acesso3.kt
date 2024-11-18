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

        val buttonYes = findViewById<Button>(R.id.botao_sim)
        val buttonNo = findViewById<Button>(R.id.botao_nao)
        var cpfTextView = findViewById<TextView>(R.id.NovoCpfView)
        var nomeTextView = findViewById<TextView>(R.id.NovoNomeView)
        val cpfNovo = intent.getStringExtra("cpf")
        val nomeNovo = intent.getStringExtra("nome")
        val senhaNovo = intent.getStringExtra("senha")
        val crmCampo = intent.getStringExtra("crm")
        val fb = Firebase.firestore

        nomeTextView.text = "Nome: ${nomeNovo.toString()}"
        cpfTextView.text = "CPF: ${cpfNovo.toString()}"

        if (cpfNovo == null || nomeNovo == null || senhaNovo == null || crmCampo == null) {
            Toast.makeText(this, "Erro ao receber dados", Toast.LENGTH_SHORT).show();
            return
        }
        buttonYes.setOnClickListener{
            val docData = hashMapOf(
                "user" to nomeNovo,
                "cpf" to cpfNovo,
                "password" to senhaNovo,
                "crm" to crmCampo,
            )
            // Salva no banco
            fb.collection("usuarios").document().set(docData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                }.addOnFailureListener {
                    Toast.makeText(this, "Erro ao salvar", Toast.LENGTH_SHORT).show();
                }

            val intentMedico = Intent(this, Menu_medico::class.java)
            val intentPaciente = Intent(this, Menu::class.java)

            if (crmCampo != "") {
                Toast.makeText(this, "Indo para menu medico", Toast.LENGTH_SHORT).show();
                startActivity(intentMedico)
            } else {
                Toast.makeText(this, "Indo para menu paciente", Toast.LENGTH_SHORT).show();
                startActivity(intentPaciente)
            }
        }
        buttonNo.setOnClickListener{
            val intent = Intent(this, Primeiro_Acesso1::class.java)
            startActivity(intent)
        }
    }
}