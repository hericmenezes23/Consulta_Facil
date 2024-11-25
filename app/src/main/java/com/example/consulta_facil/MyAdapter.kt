package com.example.consulta_facil

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var list:List<Pessoa>):RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var context = holder.item.context
        holder.tv.text = list.get(position).nome +", "+list.get(position).cidade
        holder.btn.setOnClickListener {
            var intent = Intent(holder.itemView.context,MainActivityPessoa::class.java)
            intent.putExtra("consulta",holder.tv.text.toString() )

            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}
class MyViewHolder (var item: View) :RecyclerView.ViewHolder(item){
    var tv :TextView
    var btn: Button
    init {
        tv = item.findViewById(R.id.textView)
        btn = item.findViewById(R.id.button)
    }

}