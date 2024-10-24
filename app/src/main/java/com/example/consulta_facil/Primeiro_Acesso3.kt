package com.example.consulta_facil

import android.R.attr.button
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Primeiro_Acesso3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_acesso3)

        val botaoAvancar = findViewById<Button>(R.id.buttonAvancar)
        val crmCampo = findViewById<EditText>(R.id.CRMinput)
        val intentPaciente = Intent(this, Primeiro_acesso4::class.java)

        crmCampo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Não precisa implementar
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Verifica se o EditText está preenchido
                if (s.length > 0) {
                    // Muda o texto do botão
                    botaoAvancar.setText("Avançar")
                } else {
                    // Restaura o texto original
                    botaoAvancar.setText("Pular")
                }
            }

            override fun afterTextChanged(s: Editable) {
                // Não precisa implementar
            }
        })

       // if(crmCampo.getText().toString().trim().length != 0){
       //     botaoAvancar.setText("Avançar")
       //     intent = Intent(this, Menu_medico::class.java)
       // } else {
       //     botaoAvancar.setText("Pular")
       //     intent = Intent(this, Primeiro_acesso4::class.java)
       // }

        botaoAvancar.setOnClickListener{
            if(crmCampo.getText().toString().trim().length == 0){
                startActivity(intentPaciente)
            }
            if(crmCampo.getText().toString().trim().length == 6){
                Toast.makeText(this, "Indo para menu medico", Toast.LENGTH_SHORT).show();
                val intentMedico = Intent(this, Menu_medico::class.java)
                startActivity(intentMedico)
            } else {
                Toast.makeText(this, "Digite um CRM válido", Toast.LENGTH_SHORT).show();
            }
        }
    }
}