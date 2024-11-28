package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Emitir_vacinas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emitir_vacinas)

        val fb = Firebase.firestore
        val textNomePaciente = findViewById<TextView>(R.id.textViewNomePacienteEmitirVacina)
        val textNomeVacina = findViewById<TextView>(R.id.textInputNomeVacina)
        val textDataAplicacao = findViewById<TextView>(R.id.textInputDataAplicacao)
        val emitir_vacina = findViewById<Button>(R.id.btEmitirVacina)

        val patientName = intent.getStringExtra("name").toString()
        val patientId = intent.getStringExtra("id").toString()

        textNomePaciente.text = patientName

        val spinner = findViewById<Spinner>(R.id.SpinnerHospitalVacina)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, SpinnerHospitalData.hospitalNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        emitir_vacina.setOnClickListener{

            //map to save in firebase
            val map = hashMapOf(
                "nome" to textNomeVacina.text.toString(),
                "data" to textDataAplicacao.text.toString(),
                "hospital" to SpinnerHospitalData.hospitalMap[spinner.selectedItem.toString()],
                "doctorId" to UserSession.userId,
                "doctorName" to UserSession.userName
            )

            //save in firebase
            val appointmentsRef = fb.collection("usuarios")
                .document(patientId).collection("vacinas")
            appointmentsRef.add(map).addOnSuccessListener {
                Toast.makeText(this, "Vacina emitida com sucesso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Menu_medico::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this, "Erro ao emitir vacina", Toast.LENGTH_SHORT).show()
            }
        }
    }
}