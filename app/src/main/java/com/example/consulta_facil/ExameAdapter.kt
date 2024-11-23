package com.example.consulta_facil
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExameAdapter(private var list:List<Exame>):RecyclerView.Adapter<ExamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_exames,parent,false)
        return ExamesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExamesViewHolder, position: Int) {
        val context = holder.item.context
        val exame = list[position]
        //print list
        Log.d("EXAMES", exame.toString())
        holder.nomeMedico.text = exame.nomeMedico
        holder.tipoExame.text = exame.tipoExame
        holder.dataConsulta.text = exame.data

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetalhesExame::class.java)
            intent.putExtra("exame", exame)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d("ExameAdapter", "Tamanho da lista: ${list.size}")
        return list.size
    }

}

class ExamesViewHolder (var item: View) :RecyclerView.ViewHolder(item){
    var nomeMedico: TextView = item.findViewById(R.id.nomeMedico_exame)
    var tipoExame: TextView = item.findViewById(R.id.tipo_exame)
    var dataConsulta: TextView = item.findViewById(R.id.data_exame)
}