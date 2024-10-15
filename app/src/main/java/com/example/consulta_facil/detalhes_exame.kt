package com.example.consulta_facil

import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class detalhes_exame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_exame)

        val buttonResult = findViewById<Button>(R.id.button_resultado)

        buttonResult.setOnClickListener{
            Toast.makeText(this, "Seu resultado está sendo imprimido", Toast.LENGTH_SHORT).show()
        }

    }
}