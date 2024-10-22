package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Pacientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacientes)

        val p1 = findViewById<TextView>(R.id.paciente1)
        p1.setOnClickListener {
            val intent = Intent(this, ConsultaMedico::class.java)
            startActivity(intent)
        }
    }
}