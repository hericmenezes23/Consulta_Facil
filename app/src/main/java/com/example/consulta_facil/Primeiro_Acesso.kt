package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Primeiro_Acesso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primeiro_acesso_1)

        val bt_consultas = findViewById<Button>(R.id.bem_vindo_avancar)
        bt_consultas.setOnClickListener {
            val intent = Intent(this, Primeiro_Acesso2::class.java)
            startActivity(intent)
        }
    }
}