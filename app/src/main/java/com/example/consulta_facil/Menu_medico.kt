package com.example.consulta_facil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge

class Menu_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var searchBar: EditText
        lateinit var btnSearch: Button
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_medico)

        searchBar = findViewById(R.id.search_bar)
        btnSearch = findViewById(R.id.btn_search)

        btnSearch.setOnClickListener {
            val inputText = searchBar.text.toString()
            if (inputText.isNotEmpty()) {
                // Criar intent para navegar para a tela do chatbot
                val intent = Intent(this, BuscadorIAActivity::class.java)
                intent.putExtra("search_query", inputText)
                startActivity(intent)
            }
        }

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