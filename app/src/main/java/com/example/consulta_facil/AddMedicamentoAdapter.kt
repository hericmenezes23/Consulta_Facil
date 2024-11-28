package com.example.consulta_facil

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AddMedicamentosAdapter(private val medicamentos: MutableList<Medicamento>) :
    RecyclerView.Adapter<MedicamentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicamento, parent, false)
        return MedicamentoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        val medicamento = medicamentos[position]
        holder.medicamentoNome.text = medicamento.nome
        holder.medicamentoDias.text = medicamento.dias
        holder.medicamentoPeriodicidade.text = medicamento.periodicidade
    }

    override fun getItemCount(): Int {
        return medicamentos.size
    }

    fun updateData(novoMedicamento: Medicamento) {
        Log.d(  "AddMedicamento", "medicamentos.size: ${medicamentos.size}")
        medicamentos.add(medicamentos.size, novoMedicamento)
        //print all list medicamentos
        Log.d("AddMedicamento", "medicamentos: $medicamentos")
        notifyDataSetChanged()
    }
}

class MedicamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val medicamentoNome: TextView = itemView.findViewById(R.id.textViewNomeMedic)
    val medicamentoDias: TextView = itemView.findViewById(R.id.textViewDiasMedic)
    val medicamentoPeriodicidade: TextView = itemView.findViewById(R.id.textViewPeriodicidadeMedic)
}