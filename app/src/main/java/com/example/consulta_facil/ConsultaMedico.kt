package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ConsultaMedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_medico)

        val Exame = findViewById<ImageButton>(R.id.button_emitir_exames)
        val Cirurgia = findViewById<ImageButton>(R.id.button_marcar_cirurgia)
        val Atestado = findViewById<ImageButton>(R.id.button_emitir_atestados)
        val Prescricao = findViewById<ImageButton>(R.id.button_emitir_prescricoes)
        val Consultas = findViewById<ImageButton>(R.id.button_emitir_consultas)

        val idPaciente = intent.getStringExtra("id").toString()
        val nomePaciente = intent.getStringExtra("name").toString()

        Exame.setOnClickListener{
            val intent = Intent(this, MarcarExame::class.java)
            intent.putExtra("id", idPaciente)
            intent.putExtra("name", nomePaciente)
            startActivity(intent)
        }
        Cirurgia.setOnClickListener{
            val intent = Intent(this, MarcarCirurgia::class.java)
            intent.putExtra("id", idPaciente)
            intent.putExtra("name", nomePaciente)
            startActivity(intent)
        }
        Atestado.setOnClickListener{
            val intent = Intent(this, EmitirAtestado::class.java)
            intent.putExtra("id", idPaciente)
            intent.putExtra("name", nomePaciente)
            startActivity(intent)
        }
        Prescricao.setOnClickListener{
            val intent = Intent(this, EmitirPrescricoes::class.java)
            intent.putExtra("id", idPaciente)
            intent.putExtra("name", nomePaciente)
            startActivity(intent)
        }
        Consultas.setOnClickListener{
            val intent = Intent(this, EmitirConsultas::class.java)
            intent.putExtra("id", idPaciente)
            intent.putExtra("name", nomePaciente)
            startActivity(intent)
        }
    }
}