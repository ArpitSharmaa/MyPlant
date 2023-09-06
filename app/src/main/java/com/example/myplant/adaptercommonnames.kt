package com.example.myplant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class adaptercommonnames(val commonnames:List<String>) :RecyclerView.Adapter<adaptercommonnames.ViewHolder>(){
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val textvieww = view.findViewById<TextView>(R.id.textView12)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout2,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return commonnames.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            textvieww.text = commonnames.get(position)
        }
    }
}