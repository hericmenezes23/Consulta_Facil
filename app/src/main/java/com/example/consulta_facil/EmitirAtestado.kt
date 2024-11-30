package com.example.consulta_facil

import android.content.Intent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EmitirAtestado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emitir_atestado)
        val patientName = intent.getStringExtra("name").toString()
        val patientId = intent.getStringExtra("id").toString()
        val textViewNameAtestado = findViewById<TextView>(R.id.textViewNameAtestado)
        val btCadastrarAtestado = findViewById<Button>(R.id.btCadastrarAtestado)
        val textInputTypeDescricaoAtestado = findViewById<EditText>(R.id.textInputTypeDescricaoAtestado)

        textViewNameAtestado.text = patientName

        btCadastrarAtestado.setOnClickListener{
            val map = hashMapOf("description" to textInputTypeDescricaoAtestado.text.toString())
            val fb = Firebase.firestore
            val appointmentsRef = fb.collection("usuarios")
                .document(patientId).collection("atestados")
            appointmentsRef.add(map).addOnSuccessListener { documentReference ->
                Toast.makeText(this, "Atestado cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                finish()
            }.addOnFailureListener { e ->
                Toast.makeText(this, "Erro ao cadastrar atestado: $e", Toast.LENGTH_SHORT).show()
            }
        }
    }
}