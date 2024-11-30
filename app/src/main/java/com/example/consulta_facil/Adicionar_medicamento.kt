package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Adicionar_medicamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adicionar_medicamento)

        val nomeMedic = findViewById<EditText>(R.id.textInputNomeMedic)
        val periodicidadeMedic = findViewById<EditText>(R.id.textInputPeriodicidadeMedic)
        val diasMedic = findViewById<EditText>(R.id.textInputDiasMedic)
        val btAddMedic = findViewById<Button>(R.id.btAddMedic)


        btAddMedic.setOnClickListener {
            val nomeMedicamento = nomeMedic.text.toString()
            val periodicidade = periodicidadeMedic.text.toString()
            val dias = diasMedic.text.toString()
            val medicamento = Medicamento(nomeMedicamento, periodicidade, dias)

            val intent = Intent()
            intent.putExtra("medicamento", medicamento)
            setResult(RESULT_OK, intent)
            Log.d("AdicionarMedicamento", "medicamento: $medicamento")
            finish()
        }
    }
}