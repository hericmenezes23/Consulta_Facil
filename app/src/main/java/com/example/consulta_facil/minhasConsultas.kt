package com.example.consulta_facil

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class minhasConsultas : AppCompatActivity() {
    lateinit var recy: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_minhas_consultas)

        var dataset = mutableListOf<Consulta>()
        getUserAppointments("4S8sdQreEiVDTp92096L")
        //print all consultas
        dataset.forEach {
            Log.d("CONSULTAS", it.toString())
        }
        recy = findViewById(R.id.RecyclerViewConsultas)
        val adapter = ConsultaAdapter(dataset)
        recy.layoutManager = LinearLayoutManager(this)
        recy.adapter = adapter
    }

    // Função para buscar todas as consultas de um usuário
    fun getUserAppointments(userId: String) : MutableList<Consulta> {
        val fb = Firebase.firestore
        var dataset = mutableListOf<Consulta>()
        val appointmentsRef = fb.collection("usuarios").document(userId).collection("consultas")
        appointmentsRef.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d("CONSULTAS", "${document.id} => ${document.data}")
                    // map the document data to a Consulta object
                    dataset.add( Consulta(
                        id = document.id,
                        nomeMedico = document.getString("doctorName"),
                        especialidade = document.getString("specialty"),
                        data = document.getString("date")
                    ))
                }
            }
            .addOnFailureListener { exception ->
                Log.w("CONSULTAS", "Erro ao buscar consultas: ", exception)
            }
        return dataset
    }
}