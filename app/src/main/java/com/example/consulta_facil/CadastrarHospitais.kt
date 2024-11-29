package com.example.consulta_facil

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CadastrarHospitais : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastrar_hospitais)
        val btAddHospital = findViewById<Button>(R.id.cadastrarHospital)
        val textInpuTNomeHospital = findViewById<EditText>(R.id.textInpuTNomeHospital)
        val utextoUrlHospital = findViewById<EditText>(R.id.textInputUrlHospital)

        btAddHospital.setOnClickListener {
            val fb = Firebase.firestore
            val appointmentsRef = fb.collection("hospitais")
            val map = hashMapOf(
                "name" to textInpuTNomeHospital.text.toString(),
                "url" to utextoUrlHospital.text.toString()
            )
            appointmentsRef.add(map).addOnSuccessListener { documentReference ->
                Toast.makeText(this, "Hospital cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                finish()
            }.addOnFailureListener { e ->
                Toast.makeText(this, "Erro ao cadastrar hospital: $e", Toast.LENGTH_SHORT).show()
            }
        }
    }
}