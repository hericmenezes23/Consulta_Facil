package com.example.consulta_facil

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Primeiro_Acesso2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_acesso2)
        val nomeNovo = intent.getStringExtra("nome")
        val cpfNovo = intent.getStringExtra("cpf")
        val senhaNovo = intent.getStringExtra("senha")

        val botaoAvancar = findViewById<Button>(R.id.buttonAvancar)
        val crmCampo = findViewById<EditText>(R.id.CRMinput)


        crmCampo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Não precisa implementar
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Verifica se o EditText está preenchido
                if (s.isNotEmpty()) {
                    // Muda o texto do botão
                    botaoAvancar.text = "Avançar"
                } else {
                    // Restaura o texto original
                    botaoAvancar.text = "Pular"
                }
            }

            override fun afterTextChanged(s: Editable) {
                // Não precisa implementar
            }
        })

        botaoAvancar.setOnClickListener{
            val medico = if(crmCampo.text.toString().trim().isEmpty()){
                false
            } else if(crmCampo.text.toString().trim().length == 6){
                true
            } else {
                Toast.makeText(this, "Digite um CRM válido", Toast.LENGTH_SHORT).show();
                return@setOnClickListener
            }

            Log.d("NOME", nomeNovo.toString())
            Log.d("CPF", cpfNovo.toString())
            Log.d("CRM", crmCampo.text.toString())

            val intent = Intent(this, Primeiro_Acesso3::class.java)
            intent.putExtra("cpf", cpfNovo)
            intent.putExtra("nome", nomeNovo)
            intent.putExtra("senha", senhaNovo)
            intent.putExtra("crm", crmCampo.text.toString())

            startActivity(intent)
        }
    }
}