package com.example.consulta_facil

import android.content.Intent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class atestado_prescricao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_atestado_prescricao)

        val buttonAtestado = findViewById<Button>(R.id.button_atestado)
        val buttonPrescricao = findViewById<Button>(R.id.button_prescricao)

        buttonAtestado.setOnClickListener{
            Toast.makeText(this, "Seu atestado está sendo imprimido", Toast.LENGTH_SHORT).show()
        }

        buttonPrescricao.setOnClickListener{
            Toast.makeText(this, "Sua prescrição está sendo imprimida", Toast.LENGTH_SHORT).show()
        }

    }
}