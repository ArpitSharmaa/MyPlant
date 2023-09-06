package com.example.myplant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class listfragadaptoir(val context: Context, var listof :List<plantdata>, private val listener:(int:Int)->Unit):RecyclerView.Adapter<listfragadaptoir.viewholer>() {
   var newlift :List<plantdata> =listof
    inner class viewholer(view:View):RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.imageView)
        val textview = view.findViewById<TextView>(R.id.textView)
        init {
            itemView.setOnClickListener {
                listener.invoke(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholer {
      val layout = LayoutInflater.from(parent.context).inflate(R.layout.listviewitem,parent,false)
        return viewholer(layout)
    }

    override fun getItemCount(): Int {
        return listof.size
    }

    override fun onBindViewHolder(holder: viewholer, position: Int) {
            with(holder){
                Glide.with(context).load(listof.get(position).image).into(img)
                textview.text= listof.get(position).name
            }
    }
//    fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val query = constraint.toString().toLowerCase()
//                newlift = if (query.isEmpty()) {
//                    listof
//                } else {
//                    listof.filter {
//                        it.name.toLowerCase().contains(query)
//                    }
//                }
//                val filterResults = FilterResults()
//                filterResults.values = newlift
//                return filterResults
//            }
//
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                newlift = results?.values as List<plantdata>
//                notifyDataSetChanged()
//            }
//        }
//    }


}
