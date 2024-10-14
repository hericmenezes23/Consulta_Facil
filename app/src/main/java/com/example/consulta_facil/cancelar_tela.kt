package com.example.consulta_facil

import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class cancelar_tela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cancelar_tela)

        val buttonNegar = findViewById<Button>(R.id.btn_no)
        val buttonConfirmar = findViewById<Button>(R.id.btn_yes)

        buttonNegar.setOnClickListener{
            val intent = Intent(this, detalhes_consulta::class.java)
            startActivity(intent)
        }
        buttonConfirmar.setOnClickListener{
            Toast.makeText(this, "Sua consulta foi cancelada", Toast.LENGTH_SHORT).show()
        }

    }
}