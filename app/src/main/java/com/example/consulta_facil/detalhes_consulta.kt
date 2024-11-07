package com.example.consulta_facil

import android.content.Intent
import android.widget.Button

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class detalhes_consulta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_consulta)

            val buttonCancelarConsulta = findViewById<Button>(R.id.button_cancelar)

            buttonCancelarConsulta.setOnClickListener{
                val intent = Intent(this, cancelar_tela::class.java)
                startActivity(intent)
            }
    }
}