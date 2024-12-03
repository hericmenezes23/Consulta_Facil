package com.example.consulta_facil


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class UPAAdapter(private var list: List<UPA>) : RecyclerView.Adapter<UPASviewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UPASviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_upas, parent, false)
        return UPASviewholder(view)
    }

    override fun onBindViewHolder(holder: UPASviewholder, position: Int) {
        var context = holder.item.context
        val currentUPA = list[position]
        var url = currentUPA.component2()
        holder.tv.text = list.get(position).NomeH
        holder.btn.setOnClickListener {
          val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class UPASviewholder(var item: View) : RecyclerView.ViewHolder(item) {
    lateinit var tv: TextView
    lateinit var btn: Button

    init {
        tv = item.findViewById(R.id.textView9)
        btn = item.findViewById(R.id.button2)
    }
}