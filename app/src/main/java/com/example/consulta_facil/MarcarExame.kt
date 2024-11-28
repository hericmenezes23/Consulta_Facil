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

class MarcarExame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_marcar_exame)

        val textName = findViewById<TextView>(R.id.textViewNameExams)
        val campoTipo = findViewById<EditText>(R.id.textInputTypeExam)
        val campoData = findViewById<EditText>(R.id.textInputDateExam)
        val campoHora = findViewById<EditText>(R.id.textInputHourExam)
        val btCadstrarConsulta = findViewById<Button>(R.id.cadastrarExame)
        val patientName = intent.getStringExtra("name").toString()
        val patientId = intent.getStringExtra("id").toString()
        var fb = Firebase.firestore

        textName.text = patientName

        val spinner = findViewById<Spinner>(R.id.SpinnerHospitalExam)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            SpinnerHospitalData.hospitalNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = SpinnerHospitalData.hospitalNames[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case where nothing is selected
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
                .document(patientId).collection("exames")
            appointmentsRef.add(map)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "Exame marcado com sucesso!", Toast.LENGTH_LONG).show()
                    finish()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erro ao marcar exame: $e", Toast.LENGTH_SHORT).show()
                }
        }
    }
}