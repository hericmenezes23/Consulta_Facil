package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Menu_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_medico)

        UserSession.userName = "Otavio"
        UserSession.userCpf = "12345678910"
        UserSession.userId = "LUDm9iOzuxQEntWKPtzz"

        val btNovaConsulta = findViewById<ImageButton>(R.id.button_nova_consulta)
        btNovaConsulta.setOnClickListener {
            val intent = Intent(this, ListaPacientesMedico::class.java)
            startActivity(intent)
        }

        val btEmitirAtestadoVacina = findViewById<ImageButton>(R.id.button_emitir_atestados_vacinas)
        btEmitirAtestadoVacina.setOnClickListener {
            val intent = Intent(this, PacientesVacinas::class.java)
            startActivity(intent)
        }
    }
}