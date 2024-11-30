package com.example.consulta_facil

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration

class EmitirPrescricoes : AppCompatActivity() {
    private val medicamentosList = mutableListOf<Medicamento>()
    private lateinit var addMedicamentosAdapter: AddMedicamentosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emitir_precicoes)

        val btAddMedic = findViewById<Button>(R.id.ADD_BT)
        val btEmitirPrescricao = findViewById<Button>(R.id.btEmitirPrescricao)

        medicamentosList.add(Medicamento("Medicamento 1", "2 dias", "1 vez ao dia"))
        addMedicamentosAdapter = AddMedicamentosAdapter(medicamentosList)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleViewAddMedicamentos)
        recyclerView.layoutManager = LinearLayoutManager(this) // Or another layout manager
        recyclerView.adapter = addMedicamentosAdapter

        // DividerItemDecoration
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        btAddMedic.setOnClickListener {
            val intent = Intent(this, Adicionar_medicamento::class.java)
            startActivityForResult(intent, ADD_MEDICAMENTO_REQUEST_CODE)
        }

        btEmitirPrescricao.setOnClickListener {
            // Send to firestore


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_MEDICAMENTO_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Log.d("EmitirPrescricoes", "onActivityResult")
            val medicamento = data?.getParcelableExtra<Medicamento>("medicamento")
            medicamento?.let {
                Log.d("EmitirPrescricoes", "medicamento: $it")
                addMedicamentosAdapter.updateData(it)
            }
        }
    }

    companion object {
        const val ADD_MEDICAMENTO_REQUEST_CODE = 1
    }
}
