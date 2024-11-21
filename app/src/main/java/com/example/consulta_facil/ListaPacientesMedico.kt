package com.example.consulta_facil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ListaPacientesMedico : AppCompatActivity() {
    lateinit var recy: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_pacientes)

        val dataset = mutableListOf<Consulta>()
        getUsers()
    }

    // Função para buscar todos os usuarios
    private fun getUsers() {
        val fb = Firebase.firestore
        val listaPacientes = mutableListOf<ListaPacientes>()
        val usersRef = fb.collection("usuarios")
        usersRef.get().addOnSuccessListener { documents ->
            if (documents.isEmpty) {
                // Handle the case where no users were found (e.g., show an empty state message)
                Log.d("ListaPacientes", "No users found")
                return@addOnSuccessListener
            }
            for (document in documents) {
                listaPacientes.add(ListaPacientes(
                    id = document.id,
                    name = document.getString("user") ?: "",
                ))
            }
            recy = findViewById(R.id.recy_pacientes)
            val adapter = ListaPacientesAdapter(listaPacientes, "consultas")
            recy.layoutManager = LinearLayoutManager(this)
            recy.adapter = adapter
            adapter.notifyDataSetChanged()
        }.addOnFailureListener { exception ->
            Log.w("ListaPacientes", "Erro ao buscar consultas: ", exception)
        }
    }
}