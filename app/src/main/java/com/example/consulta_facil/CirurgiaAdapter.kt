package com.example.consulta_facil
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CirurgiaAdapter(private var list:List<Cirurgia>):RecyclerView.Adapter<CirurgiasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CirurgiasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_cirurgias,parent,false)
        return CirurgiasViewHolder(view)
    }

    override fun onBindViewHolder(holder: CirurgiasViewHolder, position: Int) {
        val context = holder.item.context
        val cirurgia = list[position]
        //print list
        Log.d("EXAMES", cirurgia.toString())
        holder.nomeMedico.text = cirurgia.nomeMedico
        holder.specialty.text = cirurgia.specialty
        holder.dataCirurgia.text = cirurgia.data

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetalhesCirurgia::class.java)
            intent.putExtra("cirurgia", cirurgia)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d("CirurgiaAdapter", "Tamanho da lista: ${list.size}")
        return list.size
    }

}

class CirurgiasViewHolder (var item: View) :RecyclerView.ViewHolder(item){
    var nomeMedico: TextView = item.findViewById(R.id.nomeMedico_cirurgia)
    var specialty: TextView = item.findViewById(R.id.tipo_cirurgia)
    var dataCirurgia: TextView = item.findViewById(R.id.data_cirurgia)
}