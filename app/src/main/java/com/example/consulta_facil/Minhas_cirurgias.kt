package com.example.consulta_facil

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Minhas_cirurgias : AppCompatActivity() {
    lateinit var recy: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_minhas_cirurgias)

        var dataset = mutableListOf<Cirurgia>()
        getUserAppointments("4S8sdQreEiVDTp92096L")
        //print all consultas
        //print all consultas
        dataset.forEach {
            Log.d("CIRURGIAS", it.toString())
        }
    }

    // Função para buscar todas as consultas de um usuário
    private fun getUserAppointments(userId: String) {
        val fb = Firebase.firestore
        val dataset = mutableListOf<Cirurgia>()
        val appointmentsRef = fb.collection("usuarios").document(userId).collection("cirurgias")
        appointmentsRef.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    dataset.add( Cirurgia(
                        id = document.id,
                        nomeMedico = document.getString("doctorName"),
                        specialty = document.getString("specialty"),
                        data = document.getString("date")
                    )
                    )
                }

                recy = findViewById(R.id.RecyclerViewCirurgias)
                val adapter = CirurgiaAdapter(dataset)
                recy.layoutManager = LinearLayoutManager(this)
                recy.adapter = adapter
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("CIRURGIAS", "Erro ao buscar cirurgias: ", exception)
            }
    }
}