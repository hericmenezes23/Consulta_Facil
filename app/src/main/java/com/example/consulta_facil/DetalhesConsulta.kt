package com.example.consulta_facil

import android.content.Intent
import android.widget.Button

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DetalhesConsulta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_consulta)
        val buttonCancelarConsulta = findViewById<Button>(R.id.button_cancelar)

        val fb = Firebase.firestore
        val consulta = intent.getParcelableExtra<Consulta>("consulta")
        var endereco = ""

        if (consulta == null) {
            Toast.makeText(this, "Consulta não encontrada", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        //alterar nomes de campos
        val campoNomeMedico = findViewById<TextView>(R.id.det_consulta_nome_medico)
        val campoEspecialidade = findViewById<TextView>(R.id.det_consulta_especialidade)
        val campoData = findViewById<TextView>(R.id.det_consulta_data)
        val campoEndereco = findViewById<TextView>(R.id.det_consulta_endereço)

        campoNomeMedico.text = consulta.nomeMedico
        campoEspecialidade.text = consulta.especialidade
        campoData.text = consulta.data

        Log.d("DETALHES_CONSULTA", consulta.id.toString())

        fb.collection("usuarios").document(consulta.id.toString()).get()
            .addOnSuccessListener { doc ->
                if (doc != null && doc.exists()) {
                    endereco = doc.getString("address").toString()
                    Log.d("DETALHES_CONSULTA", endereco)
                    campoEndereco.text = endereco
                }
                else {
                    Log.d("DETALHES_CONSULTA", "No such document")
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show()
                println(exception.message)
                println(exception.stackTrace)
                println(exception.localizedMessage)
                println(exception.cause)
            }

        buttonCancelarConsulta.setOnClickListener{
            val intent = Intent(this, cancelar_tela::class.java)
            intent.putExtra("consulta", consulta)
            startActivity(intent)
        }
    }
}