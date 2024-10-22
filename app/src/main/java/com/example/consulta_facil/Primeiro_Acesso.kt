package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Primeiro_Acesso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primeiro_acesso_1)

        val botaoAvancar = findViewById<Button>(R.id.button6)
        val nomeCampo = findViewById<EditText>(R.id.nomeInput)

        botaoAvancar.setOnClickListener{
            if(nomeCampo.getText().toString().trim().length > 0){
                val intent = Intent(this, Primeiro_Acesso2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Digite um nome válido", Toast.LENGTH_SHORT).show();
            }
        }

    }
}