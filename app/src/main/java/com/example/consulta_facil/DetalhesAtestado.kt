package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DetalhesAtestado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var searchBar: EditText
        lateinit var btnSearch: Button
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_atestado)

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

        val buttonEmitirResultado = findViewById<Button>(R.id.button_imprimir)

        val fb = Firebase.firestore
        val atestado = intent.getParcelableExtra<Atestado>("atestado")
        var nomeAtestado = ""

        if (atestado == null) {
            Toast.makeText(this, "Atestado não encontrado", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        //alterar nomes de campos
        val campoNomeMedico = findViewById<TextView>(R.id.text_nome_medico_at)
        val campoData = findViewById<TextView>(R.id.text_data_at)
        val campoNomeAtestado = findViewById<TextView>(R.id.nome_atestado)

        if (campoNomeMedico == null || campoData == null || campoNomeAtestado == null) {
            Toast.makeText(this, "informação não encontrado", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        campoNomeMedico.text = atestado.nomeMedico
        campoNomeAtestado.text = atestado.specialty
        campoData.text = atestado.data

        Log.d("DETALHES_ATESTADO", atestado.id.toString())
        Log.d("DATA:", atestado.data.toString())
        Log.d("SPECIALTY:", atestado.specialty.toString())

        fb.collection("usuarios").document(atestado.id.toString()).get()
            .addOnSuccessListener { doc ->
                if (doc != null && doc.exists()) {
                    nomeAtestado = doc.getString("specialty").toString()
                    Log.d("DETALHES_ATESTADO", nomeAtestado)
                    campoNomeAtestado.text = nomeAtestado
                }
                else {
                    Log.d("DETALHES_ATESTADO", "No such document")
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show()
                println(exception.message)
                println(exception.stackTrace)
                println(exception.localizedMessage)
                println(exception.cause)
            }

        buttonEmitirResultado.setOnClickListener{
            Toast.makeText(this, "Imprimindo Atestado/Prescrição", Toast.LENGTH_SHORT).show()
        }
    }
}