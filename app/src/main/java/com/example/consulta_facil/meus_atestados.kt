package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class meus_atestados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_minhas_consultas)

        val Consulta1 = findViewById<ImageButton>(R.id.imageView2)
        val Consulta2 = findViewById<ImageButton>(R.id.imageView3)
        val Consulta3 = findViewById<ImageButton>(R.id.imageView4)
        val Consulta4 = findViewById<ImageButton>(R.id.imageView5)

        Consulta1.setOnClickListener{
            val intent = Intent(this, EmitirAtestado::class.java)
            startActivity(intent)
        }
        Consulta2.setOnClickListener{
            val intent = Intent(this, EmitirAtestado::class.java)
            startActivity(intent)
        }
        Consulta3.setOnClickListener{
            val intent = Intent(this, EmitirAtestado::class.java)
            startActivity(intent)
        }
        Consulta4.setOnClickListener{
            val intent = Intent(this, EmitirAtestado::class.java)
            startActivity(intent)
        }
    }
}