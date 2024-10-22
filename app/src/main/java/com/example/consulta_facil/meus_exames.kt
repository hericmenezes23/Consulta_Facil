package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class meus_exames : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meus_exames)
        val Exame1 = findViewById<ImageButton>(R.id.imageView2)
        val Exame2 = findViewById<ImageButton>(R.id.imageView3)
        val Exame3 = findViewById<ImageButton>(R.id.imageView4)
        val Exame4 = findViewById<ImageButton>(R.id.imageView5)

        Exame1.setOnClickListener{
            val intent = Intent(this, detalhes_exame::class.java)
            startActivity(intent)
        }
        Exame2.setOnClickListener{
            val intent = Intent(this, detalhes_exame::class.java)
            startActivity(intent)
        }
        Exame3.setOnClickListener{
            val intent = Intent(this, detalhes_exame::class.java)
            startActivity(intent)
        }
        Exame4.setOnClickListener{
            val intent = Intent(this, detalhes_exame::class.java)
            startActivity(intent)
        }
    }
}