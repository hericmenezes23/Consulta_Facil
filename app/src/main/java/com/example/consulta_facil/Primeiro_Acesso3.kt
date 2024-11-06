package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Primeiro_Acesso3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_acesso3)

        val botao_sim = findViewById<Button>(R.id.botao_sim)

        val botao_nao = findViewById<Button>(R.id.botao_nao)

        botao_sim.setOnClickListener{
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
        botao_nao.setOnClickListener{
            val intent = Intent(this, Primeiro_Acesso1::class.java)
            startActivity(intent)
        }

    }
}