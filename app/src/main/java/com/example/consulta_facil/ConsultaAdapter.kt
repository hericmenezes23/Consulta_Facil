package com.example.consulta_facil
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ConsultaAdapter(private var list:List<Consulta>):RecyclerView.Adapter<ConsultasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_consultas,parent,false)
        return ConsultasViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConsultasViewHolder, position: Int) {
        val context = holder.item.context
        val consulta = list[position]
        //print list
        Log.d("CONSULTAS", consulta.toString())
        holder.nomeMedico.text = consulta.nomeMedico
        holder.especialidade.text = consulta.especialidade
        holder.dataConsulta.text = consulta.data

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetalhesConsulta::class.java)
            intent.putExtra("consulta", consulta)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d("ConsultaAdapter", "Tamanho da lista: ${list.size}")
        return list.size
    }

}

class ConsultasViewHolder (var item: View) :RecyclerView.ViewHolder(item){
    var nomeMedico: TextView = item.findViewById(R.id.nomeMedico_cirurgia)
    var especialidade: TextView = item.findViewById(R.id.tipo_cirurgia)
    var dataConsulta: TextView = item.findViewById(R.id.data_cirurgia)
}