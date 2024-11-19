package com.example.consulta_facil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.consulta_facil.MyAdapter
import com.example.consulta_facil.R

class MainActivity2 : AppCompatActivity() {
    lateinit var recy: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val dataset = listOf<String>("Narak","Huan","Alberto","Estrogolosopeudo","Heric","Henrrique","Maia","Jubiscleudo"
            ,"Ernesto","Brandao","Atila","Pedro","Joao P.")
        recy = findViewById(R.id.RecyclerView)
        val adapter = MyAdapter(dataset)
        recy.layoutManager = LinearLayoutManager(this)
        recy.adapter = adapter
    }
}