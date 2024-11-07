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
        var nomeNovo = intent.getStringExtra("nome")
        var cpfNovo = intent.getStringExtra("cpf")

        val botaoAvancar = findViewById<Button>(R.id.buttonAvancar)
        val crmCampo = findViewById<EditText>(R.id.CRMinput)
        val intentMedico = Intent(this, Menu_medico::class.java)
        val intentPaciente = Intent(this, Primeiro_Acesso3::class.java)
        val fb = Firebase.firestore

//        val cpf = intent.getStringExtra("cpf")
//        val nome = intent.getStringExtra("nome")

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
//            if (userData == null) {
//                return@setOnClickListener
//            }
            Log.d("NOME", nomeNovo.toString())
            Log.d("CPF", cpfNovo.toString())
            Log.d("CRM", crmCampo.text.toString())
            //Log.d("PASSWORD", userData.senha)

            val docData = hashMapOf(
                "user" to nomeNovo,
                "cpf" to cpfNovo,
                "crm" to crmCampo.text.toString(),
                "password" to ""
            )
            // Salva no banco
                fb.collection("usuarios").document().set(docData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                }.addOnFailureListener {
                    Toast.makeText(this, "Erro ao salvar", Toast.LENGTH_SHORT).show();
                }

            if (medico) {
                Toast.makeText(this, "Indo para menu medico", Toast.LENGTH_SHORT).show();
                startActivity(intentMedico)
            } else {
                startActivity(intentPaciente)
            }
        }
    }
}