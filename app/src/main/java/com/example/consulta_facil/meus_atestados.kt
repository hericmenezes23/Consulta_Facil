package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class meus_atestados : AppCompatActivity() {
    lateinit var recy: RecyclerView
    lateinit var searchBar: EditText
    lateinit var btnSearch: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meus_atestados)

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
        var dataset = mutableListOf<Atestado>()
        getUserAppointments("4S8sdQreEiVDTp92096L")
        dataset.forEach {
            Log.d("ATESTADOS", it.toString())
        }
    }
        private fun getUserAppointments(userId: String) {
            val fb = Firebase.firestore
            val dataset = mutableListOf<Atestado>()
            val appointmentsRef = fb.collection("usuarios").document(userId).collection("atestados")
            appointmentsRef.get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        dataset.add( Atestado(
                            id = document.id,
                            nomeMedico = document.getString("doctorName"),
                            specialty = document.getString("specialty"),
                            data = document.getString("date")
                        ))
                    }

                    recy = findViewById(R.id.RecyclerViewAtestados)
                    val adapter = AtestadoAdapter(dataset)
                    recy.layoutManager = LinearLayoutManager(this)
                    recy.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
                .addOnFailureListener { exception ->
                    Log.w("ATESTADOS", "Erro ao buscar atestados: ", exception)
                }
        }
}