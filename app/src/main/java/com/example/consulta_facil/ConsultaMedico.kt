package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ConsultaMedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_medico)

        val Exame = findViewById<ImageButton>(R.id.button_emitir_exames)
        val Cirurgia = findViewById<ImageButton>(R.id.button_marcar_cirurgia)
        val Atestadoprescricao = findViewById<ImageButton>(R.id.button_emitir_atestados_prescricoes)
        val idPaciente = intent.getStringExtra("id").toString()
        val nomePaciente = intent.getStringExtra("name").toString()

        Exame.setOnClickListener{
            val intent = Intent(this, EmitirExame::class.java)
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
        Atestadoprescricao.setOnClickListener{
            val intent = Intent(this, atestado_prescricao::class.java)
            intent.putExtra("id", idPaciente)
            intent.putExtra("name", nomePaciente)
            startActivity(intent)
        }
    }
}