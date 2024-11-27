package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class minhasConsultas : AppCompatActivity() {
    lateinit var searchBar: EditText
    lateinit var btnSearch: Button
    lateinit var recy: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_minhas_consultas)

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

        var dataset = mutableListOf<Consulta>()
        getUserAppointments("4S8sdQreEiVDTp92096L")
        dataset.forEach {
            Log.d("CONSULTAS", it.toString())
        }
    }

    // Função para buscar todas as consultas de um usuário
    private fun getUserAppointments(userId: String) {
        val fb = Firebase.firestore
        val dataset = mutableListOf<Consulta>()
        val appointmentsRef = fb.collection("usuarios").document(userId).collection("consultas")
        appointmentsRef.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    dataset.add( Consulta(
                        id = document.id,
                        nomeMedico = document.getString("doctorName"),
                        especialidade = document.getString("specialty"),
                        data = document.getString("date")
                    ))
                }

                recy = findViewById(R.id.RecyclerViewConsultas)
                val adapter = ConsultaAdapter(dataset)
                recy.layoutManager = LinearLayoutManager(this)
                recy.adapter = adapter
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("CONSULTAS", "Erro ao buscar consultas: ", exception)
            }
    }
}