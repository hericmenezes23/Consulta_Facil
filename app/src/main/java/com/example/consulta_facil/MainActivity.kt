package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var recy:RecyclerView
    lateinit var fb:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fb = Firebase.firestore
        recy = findViewById(R.id.recyclerView)
        var list: MutableList<Pessoa> = mutableListOf()

        recy.layoutManager = LinearLayoutManager(this)


        fb.collection("usuarios").get().addOnSuccessListener {
            arquivos ->

            for (doc in arquivos){
               list.add(Pessoa(
                   doc.get("nome").toString()
                   ,doc.get("cidade").toString()))

            }
            var adapter = MyAdapter(list)
            recy.adapter = adapter

        }

        startActivity(Intent(this,MainActivityPessoa::class.java).putExtra("consulta","valores1231asd"))
    }
}