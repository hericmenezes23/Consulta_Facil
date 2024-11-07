package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Primeiro_Acesso2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primeiro_acesso_1)
        val bt_consultas = findViewById<Button>(R.id.bem_vindo_avancar)
        var fb = Firebase.firestore

        bt_consultas.setOnClickListener {
            val intent = Intent(this, Primeiro_Acesso3::class.java)
            startActivity(intent)
        }
    }
}