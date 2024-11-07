package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class ConsultaMedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_medico)

        val Exame = findViewById<ImageButton>(R.id.button_emitir_exames)
        val Cirurgia = findViewById<ImageButton>(R.id.button_marcar_cirurgia)
        val Atestadoprescricao = findViewById<ImageButton>(R.id.button_emitir_atestados_prescricoes)

        Exame.setOnClickListener{
            val intent = Intent(this, EmitirExame::class.java)
            startActivity(intent)
        }
        Cirurgia.setOnClickListener{
            val intent = Intent(this, MarcarCirurgia::class.java)
            startActivity(intent)
        }
        Atestadoprescricao.setOnClickListener{
            val intent = Intent(this, atestado_prescricao::class.java)
            startActivity(intent)
        }

    }
}