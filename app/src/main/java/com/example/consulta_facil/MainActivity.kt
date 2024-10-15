package com.example.consulta_facil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.content.Intent
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bt_consultas = findViewById<ImageButton>(R.id.button_minhas_consultas)
        bt_consultas.setOnClickListener {
            val intent = Intent(this, minhas_consultas::class.java)
            startActivity(intent)
        }

        val bt_exames = findViewById<ImageButton>(R.id.button_meus_exames)
        bt_exames.setOnClickListener {
            val intent = Intent(this, minhas_consultas::class.java)
            startActivity(intent)
        }

        val bt_upas_proximas = findViewById<ImageButton>(R.id.button_upas_proximas)
        bt_upas_proximas.setOnClickListener {
            val intent = Intent(this, minhas_consultas::class.java)
            startActivity(intent)
        }

        val bt_cirurgias = findViewById<ImageButton>(R.id.button_minhas_cirurgias)
        bt_cirurgias.setOnClickListener {
            val intent = Intent(this, minhas_consultas::class.java)
            startActivity(intent)
        }

        val bt_atestados_prescricoes = findViewById<ImageButton>(R.id.button_atestados_prescricoes)
        bt_atestados_prescricoes.setOnClickListener {
            val intent = Intent(this, minhas_consultas::class.java)
            startActivity(intent)
        }

        val bt_vacinas = findViewById<ImageButton>(R.id.button_minhas_vacinas)
        bt_vacinas.setOnClickListener {
            val intent = Intent(this, minhas_consultas::class.java)
            startActivity(intent)
        }
    }
}