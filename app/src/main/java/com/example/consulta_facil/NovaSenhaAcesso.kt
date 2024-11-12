package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NovaSenhaAcesso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_senha_acesso)
        val sendButton = findViewById<Button>(R.id.EntrarSenha)
        val novaSenha = findViewById<EditText>(R.id.NovaSenha)
        val novaSenha2 = findViewById<EditText>(R.id.NovaSenha2)

        val nomeNovo = intent.getStringExtra("nome")
        val cpfNovo = intent.getStringExtra("cpf")
        val crmNovo = intent.getStringExtra("crm")

        sendButton.setOnClickListener {
            if (novaSenha.text.toString() != novaSenha2.text.toString()) {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, Primeiro_Acesso3::class.java)
            intent.putExtra("nome", nomeNovo)
            intent.putExtra("cpf", cpfNovo)
            intent.putExtra("senha", novaSenha.text.toString())
            intent.putExtra("crm", crmNovo.toString())

            startActivity(intent)
        }
    }
}