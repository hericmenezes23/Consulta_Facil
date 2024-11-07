package com.example.consulta_facil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NovaSenhaAcesso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_senha_acesso)

        var nomeNovo = intent.getStringExtra("nome")
        var cpfNovo = intent.getStringExtra("cpf")


    }
}