package com.example.consulta_facil

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EmitirConsultas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emitir_consultas)

        val textName = findViewById<TextView>(R.id.textViewNameConsult)
        val campoTipo = findViewById<EditText>(R.id.textInputTypeConsult)
        val campoData = findViewById<EditText>(R.id.textInputDateConsult)
        val campoHora = findViewById<EditText>(R.id.textInputHourConsult)
        val btCadstrarConsulta = findViewById<Button>(R.id.cadastrarConsulta)
        val patientName = intent.getStringExtra("name").toString()
        val patientId = intent.getStringExtra("id").toString()
        val fb = Firebase.firestore

        textName.text = patientName

        val spinner = findViewById<Spinner>(R.id.SpinnerHospitalConsult)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, SpinnerHospitalData.hospitalNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        btCadstrarConsulta.setOnClickListener{
            // Check if any of the fields are empty
            if (campoTipo.text.isEmpty() || campoData.text.isEmpty() || campoHora.text.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //map to save in firebase
            val map = hashMapOf(
                "doctorId" to UserSession.userId,
                "doctorName" to UserSession.userName,
                "specialty" to campoTipo.text.toString(),
                "date" to campoData.text.toString(),
                "hour" to campoHora.text.toString(),
                "hospital" to spinner.selectedItem.toString(),
                "address_url" to SpinnerHospitalData.hospitalMap[spinner.selectedItem.toString()]
            )

            //save in firebase
            val appointmentsRef = fb.collection("usuarios")
                .document(patientId).collection("consultas")
            appointmentsRef.add(map)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "Consulta marcada com sucesso!", Toast.LENGTH_LONG).show()
                    finish()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erro ao marcar consulta: $e", Toast.LENGTH_SHORT).show()
                }
        }
    }
}