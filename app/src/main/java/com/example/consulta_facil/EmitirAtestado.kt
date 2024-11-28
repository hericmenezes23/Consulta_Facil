package com.example.consulta_facil

import android.content.Intent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EmitirAtestado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emitir_atestado)
        val patientName = intent.getStringExtra("name").toString()
        val textViewNameAtestado = findViewById<TextView>(R.id.textViewNameAtestado)
        val btCadastrarAtestado = findViewById<Button>(R.id.btCadastrarAtestado)

        textViewNameAtestado.text = patientName

        btCadastrarAtestado.setOnClickListener{
            Toast.makeText(this, "Seu atestado está sendo gerado...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Menu_medico::class.java)
            startActivity(intent)
        }
    }
}