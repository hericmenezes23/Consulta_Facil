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

class EmitirPrescricoes : AppCompatActivity() {
    private lateinit var addMedicamentoLauncher: ActivityResultLauncher<Intent>
    private val medicamentosList = mutableListOf<Medicamento>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emitir_precicoes)

        val btAddMedic = findViewById<Button>(R.id.ADD_BT)

        medicamentosList.add(Medicamento("Medicamento 1", "2 dias", "1 vez ao dia"))
        val recyclerView = findViewById<RecyclerView>(R.id.recycleViewAddMedicamentos)
        recyclerView.layoutManager = LinearLayoutManager(this) // Or another layout manager
        recyclerView.adapter = AddMedicamentosAdapter(medicamentosList)


        addMedicamentoLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Log.d("AddMedicamento", "Result OK")
                val data: Intent? = result.data
                val novoMedicamento = data?.getParcelableExtra<Medicamento>("medicamento")
                novoMedicamento?.let {
                    Log.d("AddMedicamento", "Novo medicamento: $it")
                    val adapter = recyclerView.adapter as AddMedicamentosAdapter
                    adapter.updateData(it)
                }
            }
        }

        btAddMedic.setOnClickListener {
            val intent = Intent(this, Adicionar_medicamento::class.java)
            addMedicamentoLauncher.launch(intent)
        }
    }
}
