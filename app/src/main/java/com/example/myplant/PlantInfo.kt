package com.example.myplant

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
lateinit var listtt:List<plantdata>
class PlantInfo : Fragment() {

        private var inte:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.getlist()
        arguments?.let {
            inte = it.getInt("hello")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plant_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("hello", "onViewCreated:${inte} ")

        if (viewmodel.filteredlistr==null){
            listtt=viewmodel.livelist.value!!
        } else {
           listtt= viewmodel.filteredlistr!!
        }
        val picture = view.findViewById<ImageView>(R.id.imageView2)
        val namess = view.findViewById<TextView>(R.id.Name)
        val listcommon = view.findViewById<RecyclerView>(R.id.commonanameslist)
        val textde = view.findViewById<TextView>(R.id.deatails)
        namess.text = listtt.get(inte!!)?.name ?: "hi"
        Glide.with(requireContext()).load(listtt.get(inte!!).image).into(picture)
        textde.text = listtt.get(inte!!).taxanomy
        listcommon.apply {
            layoutManager=LinearLayoutManager(context)
            adapter = adaptercommonnames(listtt.get(inte!!).Common_names)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewmodel.filteredlistr = null
    }
}