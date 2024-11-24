package com.example.consulta_facil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AddMedicamentosAdapter(private val medicamentos: List<String>) :
    RecyclerView.Adapter<AddMedicamentosAdapter.MedicamentoViewHolder>() {

    class MedicamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val medicamentoTextView: TextView = itemView.findViewById(R.id.recycleViewAddMedicamentos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicamento, parent, false)
        return MedicamentoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        holder.medicamentoTextView.text = medicamentos[position]
    }

    override fun getItemCount(): Int {
        return medicamentos.size
    }
}