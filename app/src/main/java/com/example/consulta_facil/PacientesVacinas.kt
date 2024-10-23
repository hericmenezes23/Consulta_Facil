package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class PacientesVacinas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacientes_vacinas)

        val p1 = findViewById<TextView>(R.id.paciente_vacina1)
        p1.setOnClickListener {
            val intent = Intent(this, Emitir_vacinas::class.java)
            startActivity(intent)
        }
    }
}