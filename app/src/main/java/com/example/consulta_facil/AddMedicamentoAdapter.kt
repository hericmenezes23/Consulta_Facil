package com.example.consulta_facil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AddMedicamentosAdapter(private val medicamentos: List<Medicamento>) :
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
}

class MedicamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val medicamentoNome: TextView = itemView.findViewById(R.id.textInputNomeMedic)
    val medicamentoDias: TextView = itemView.findViewById(R.id.textInputDiasMedic)
    val medicamentoPeriodicidade: TextView = itemView.findViewById(R.id.textInputPeriodicidadeMedic)
}