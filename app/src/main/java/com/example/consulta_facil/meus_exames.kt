package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class meus_exames : AppCompatActivity() {
    lateinit var recy: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meus_exames)

        var dataset = mutableListOf<Exame>()
        getUserAppointments("4S8sdQreEiVDTp92096L")

        dataset.forEach {
            Log.d("EXAMES", it.toString())
        }
    }

    // Função para buscar todas as consultas de um usuário
    private fun getUserAppointments(userId: String) {
        val fb = Firebase.firestore
        val dataset = mutableListOf<Exame>()
        val appointmentsRef = fb.collection("usuarios").document(userId).collection("exames")
        appointmentsRef.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    dataset.add( Exame(
                        id = document.id,
                        nomeMedico = document.getString("doctorName"),
                        specialty = document.getString("specialty"),
                        data = document.getString("date"),
                        hour = document.getString("hour")
                    ))
                }

                recy = findViewById(R.id.RecyclerViewExames)
                val adapter = ExameAdapter(dataset)
                Log.d("EXAME:", adapter.getItemCount().toString())
                recy.layoutManager = LinearLayoutManager(this)
                recy.adapter = adapter
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("EXAMES", "Erro ao buscar exames: ", exception)
            }
    }
}