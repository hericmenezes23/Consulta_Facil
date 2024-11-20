package com.example.consulta_facil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.widget.ImageButton


class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val bt_consultas = findViewById<ImageButton>(R.id.button_minhas_consultas)
        bt_consultas.setOnClickListener {
            val intent = Intent(this, minhasConsultas::class.java)
            startActivity(intent)
        }

        val bt_exames = findViewById<ImageButton>(R.id.button_meus_exames)
        bt_exames.setOnClickListener {
            val intent = Intent(this, meus_exames::class.java)
            startActivity(intent)
        }

        val bt_upas_proximas = findViewById<ImageButton>(R.id.button_upas_proximas)
        bt_upas_proximas.setOnClickListener {
            val intent = Intent(this, upas_proximas::class.java)
            startActivity(intent)
        }

        val bt_vacinas = findViewById<ImageButton>(R.id.button_minhas_vacinas)
        bt_vacinas.setOnClickListener {
            val intent = Intent(this, PacientesVacinas::class.java)
            startActivity(intent)
        }
    }
}