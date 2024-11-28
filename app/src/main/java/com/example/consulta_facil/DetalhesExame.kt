package com.example.consulta_facil

import android.content.Intent
import android.widget.Button

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DetalhesExame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_exame)
        val buttonEmitirResultado = findViewById<Button>(R.id.button_resultado)

        val fb = Firebase.firestore
        val exame = intent.getParcelableExtra<Exame>("exame")

        if (exame == null) {
            Toast.makeText(this, "Exame não encontrado", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        //alterar nomes de campos
        val campoNomeMedico = findViewById<TextView>(R.id.text_nome_medico)
        val campoData = findViewById<TextView>(R.id.text_data)
        val campoNomeExame = findViewById<TextView>(R.id.nome_exame)

        campoNomeMedico.text = exame.nomeMedico
        campoNomeExame.text = exame.specialty
        campoData.text = exame.data

        Log.d("DETALHES_EXAME", exame.id.toString())
        Log.d("DATA:", exame.data.toString())
        Log.d("SPECIALTY:", exame.specialty.toString())

        fb.collection("usuarios").document(exame.id.toString()).get()
            .addOnSuccessListener { doc ->
                if (doc != null && doc.exists()) {
                    nomeExame = doc.getString("examType").toString()
                    Log.d("DETALHES_EXAME", nomeExame)
                    campoNomeExame.text = nomeExame
                }
                else {
                    Log.d("DETALHES_EXAME", "No such document")
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show()
                println(exception.message)
                println(exception.stackTrace)
                println(exception.localizedMessage)
                println(exception.cause)
            }

        buttonEmitirResultado.setOnClickListener{
            Toast.makeText(this, "Emitindo resultado", Toast.LENGTH_SHORT).show()
        }
    }
}