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

class DetalhesCirurgia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_cirurgia)

        val fb = Firebase.firestore
        val cirurgia = intent.getParcelableExtra<Cirurgia>("cirurgia")
        var nomeCirurgia = ""

        if (cirurgia == null) {
            Toast.makeText(this, "Cirurgia não encontrada", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        //alterar nomes de campos
        val campoNomeMedico = findViewById<TextView>(R.id.cirurgia_medico)
        val campoData = findViewById<TextView>(R.id.cirurgia_data)
        val campoNomeCirurgia = findViewById<TextView>(R.id.cirurgia_nome)

        campoNomeMedico.text = cirurgia.nomeMedico
        campoNomeCirurgia.text = cirurgia.specialty
        campoData.text = cirurgia.data

        Log.d("DETALHES_EXAME", cirurgia.id.toString())
        Log.d("DATA:", cirurgia.data.toString())
        Log.d("SPECIALTY:", cirurgia.specialty.toString())

        fb.collection("usuarios").document(cirurgia.id.toString()).get()
            .addOnSuccessListener { doc ->
                if (doc != null && doc.exists()) {
                    nomeCirurgia = doc.getString("examType").toString()
                    Log.d("DETALHES_CIRURGIA", nomeCirurgia)
                    campoNomeCirurgia.text = nomeCirurgia
                }
                else {
                    Log.d("DETALHES_CIRURGIA", "No such document")
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