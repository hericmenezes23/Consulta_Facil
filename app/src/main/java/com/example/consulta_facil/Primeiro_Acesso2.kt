package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Primeiro_Acesso2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_acesso2)

        val botaoAvancar = findViewById<Button>(R.id.cadastrar)
        val cpfCampo = findViewById<EditText>(R.id.CPFView)

        botaoAvancar.setOnClickListener{
            if(cpfCampo.getText().toString().trim().length == 11){
                val intent = Intent(this, Primeiro_Acesso3::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Digite um CPF válido", Toast.LENGTH_SHORT).show();
            }
        }
    }
}