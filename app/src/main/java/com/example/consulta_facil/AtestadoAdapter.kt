package com.example.consulta_facil
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AtestadoAdapter(private var list:List<Atestado>):RecyclerView.Adapter<AtestadosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtestadosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_atestados,parent,false)
        return AtestadosViewHolder(view)
    }

    override fun onBindViewHolder(holder: AtestadosViewHolder, position: Int) {
        val context = holder.item.context
        val atestado = list[position]
        //print list
        Log.d("ATESTADOS", atestado.toString())
        holder.nomeMedico.text = atestado.nomeMedico
        holder.especialidade.text = atestado.specialty
        holder.dataAtestado.text = atestado.data

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetalhesAtestado::class.java)
            intent.putExtra("atestado", atestado)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d("AtestadoAdapter", "Tamanho da lista: ${list.size}")
        return list.size
    }

}

class AtestadosViewHolder (var item: View) :RecyclerView.ViewHolder(item){
    var nomeMedico: TextView = item.findViewById(R.id.nomeMedico_atestado)
    var especialidade: TextView = item.findViewById(R.id.tipo_atestado)
    var dataAtestado: TextView = item.findViewById(R.id.data_atestado)
}