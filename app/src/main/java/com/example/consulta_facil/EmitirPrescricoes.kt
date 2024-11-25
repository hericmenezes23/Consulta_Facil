package com.example.consulta_facil

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val recyclerView = findViewById<RecyclerView>(R.id.recycleViewAddMedicamentos)
        recyclerView.layoutManager = LinearLayoutManager(this) // Or another layout manager
        recyclerView.adapter = AddMedicamentosAdapter(medicamentosList)


        addMedicamentoLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val novoMedicamento = data?.getParcelableExtra<Medicamento>("medicamento")
                novoMedicamento?.let {
                    medicamentosList.add(it)
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }
        }

        btAddMedic.setOnClickListener {
            val intent = Intent(this, Adicionar_medicamento::class.java)
            addMedicamentoLauncher.launch(intent)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_CODE_ADD_MEDICAMENTO && resultCode == Activity.RESULT_OK) {
//            val novoMedicamento = data?.getStringExtra("nome_medicamento")
//            novoMedicamento?.let {
//                medicamentosList.add(it)
//                addMedicamentosAdapter.notifyDataSetChanged()
//            }
//        }
//    }

//    companion object {
//        private const val REQUEST_CODE_ADD_MEDICAMENTO = 1
//    }
}
