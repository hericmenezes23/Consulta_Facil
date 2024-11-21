package com.example.consulta_facil

import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class cancelar_tela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cancelar_tela)

        val buttonNegar = findViewById<Button>(R.id.botao_nao)
        val buttonConfirmar = findViewById<Button>(R.id.btn_yes)
        val fb = Firebase.firestore
        val consulta = intent.getParcelableExtra<Consulta>("consulta")

        if (consulta == null) {
            Toast.makeText(this, "Cancelar: Consulta não encontrada", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val txtSpec = findViewById<TextView>(R.id.tv_doctor_info_spec)
        val txtNome = findViewById<TextView>(R.id.tv_doctor_info_nome)
        val txtData = findViewById<TextView>(R.id.tv_doctor_info_data)

        txtSpec.text = consulta.especialidade
        txtNome.text = consulta.nomeMedico
        txtData.text = consulta.data

        buttonNegar.setOnClickListener{
            val intent = Intent(this, DetalhesConsulta::class.java)
            startActivity(intent)
        }
        buttonConfirmar.setOnClickListener {
            fb.collection("usuarios").document(consulta.id.toString()).delete()
            Toast.makeText(this, "Sua consulta foi cancelada.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, minhasConsultas::class.java)
            startActivity(intent)
        }
    }
}