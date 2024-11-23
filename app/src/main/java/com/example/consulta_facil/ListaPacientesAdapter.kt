package com.example.consulta_facil

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaPacientesAdapter(
    private var list:List<ListaPacientes>, private var nextView: String
): RecyclerView.Adapter<ListaPacientesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaPacientesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_lista_pacientes,parent,false)
        return ListaPacientesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListaPacientesViewHolder, position: Int) {
        holder.paciente.text = list[position].name
        holder.itemView.setOnClickListener {
            if(nextView == "consultas") {
                val intent = Intent(holder.item.context, ConsultaMedico::class.java)
                intent.putExtra("id", list[position].id)
                intent.putExtra("name", list[position].name)
                holder.item.context.startActivity(intent)
            } else if(nextView == "vacinas") {
                val intent = Intent(holder.item.context, Emitir_vacinas::class.java)
                intent.putExtra("id", list[position].id)
                intent.putExtra("name", list[position].name)
                holder.item.context.startActivity(intent)
            }
        }
    }
}

class ListaPacientesViewHolder (var item: View) :RecyclerView.ViewHolder(item){
    var paciente: TextView = item.findViewById(R.id.recyc_nome_paciente)
}