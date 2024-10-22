package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class PacientesVacinas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacientes_vacinas)

        val p1 = findViewById<ImageButton>(R.id.paciente_vacina1)
        p1.setOnClickListener {
            val intent = Intent(this, PacientesVacinas::class.java)
            startActivity(intent)
        }
    }
}