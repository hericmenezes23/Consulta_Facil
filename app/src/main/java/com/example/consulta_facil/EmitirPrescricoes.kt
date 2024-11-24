package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EmitirPrescricoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emitir_precicoes)

        // Encontrar o botão pelo ID
        val buttonChangeScreen = findViewById<Button>(R.id.ADD_BT)

        // Definir a ação ao clicar no botão
        buttonChangeScreen.setOnClickListener {
            // Criar um Intent para abrir a SecondActivity
            val intent = Intent(this, Adicionar_medicamento::class.java)
            startActivity(intent)  // Iniciar a nova Activity
        }
    }
}
