package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Emitir_vacinas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emitir_vacinas)


        val emitir_vacina = findViewById<Button>(R.id.button5)

        emitir_vacina.setOnClickListener{
            Toast.makeText(this, "Vacina emitida com sucesso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Menu_medico::class.java)
            startActivity(intent)
        }
    }
}