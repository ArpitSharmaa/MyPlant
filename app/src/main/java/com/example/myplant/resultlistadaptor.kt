package com.example.myplant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class resultlistadaptor(val list: List<PlantNetResult>): RecyclerView.Adapter<resultlistadaptor.viewholder>() {
    class viewholder(view:View):RecyclerView.ViewHolder(view){
        val genus = view.findViewById<TextView>(R.id.genus)
        val family = view.findViewById<TextView>(R.id.family)
        val common = view.findViewById<RecyclerView>(R.id.commonnames)
        val twxt = view.findViewById<TextView>(R.id.score)
        val name = view.findViewById<TextView>(R.id.textView10)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout,parent,false)
        return viewholder(layout)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        with(holder){
            genus.text= list.get(position).species.genus.scientificName
            family.text=list.get(position).species.family.scientificName
            twxt.text = list.get(position).score.toString()
            name.text= list.get(position).species.scientificName
            common.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = adaptercommonnames(list[position].species.commonNames)
            }
        }
    }

}