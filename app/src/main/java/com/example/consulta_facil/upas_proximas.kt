package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class upas_proximas : AppCompatActivity() {
    lateinit var searchBar: EditText
    lateinit var btnSearch: Button
    lateinit var recy:RecyclerView
    lateinit var fb:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_upas_proximas)

        fb = Firebase.firestore
        recy = findViewById(R.id.recy)
        searchBar = findViewById(R.id.search_bar)
        btnSearch = findViewById(R.id.btn_search)
        var list: MutableList<UPA> = mutableListOf()

        recy.layoutManager = LinearLayoutManager(this)

        fb.collection("hospitais").get().addOnSuccessListener { docs ->

            for(doc in docs){
                list.add(UPA(
                    doc.get("name").toString(),
                    doc.get("url").toString()
                ))
            }
            var adapter = UPAAdapter(list)
            recy.adapter = adapter
        }

        btnSearch.setOnClickListener {
            val inputText = searchBar.text.toString()
            if (inputText.isNotEmpty()) {
                // Criar intent para navegar para a tela do chatbot
                val intent = Intent(this, BuscadorIAActivity::class.java)
                intent.putExtra("search_query", inputText)
                startActivity(intent)
            }
        }
    }
}