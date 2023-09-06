package com.example .myplant

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.util.query


class listfrag : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listfrag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = viewmodel.livelist
        var adapterr:listfragadaptoir? = null
        Log.d("hello", "onViewCreated: ${list.value}")
        val recycle = view.findViewById<RecyclerView>(R.id.listviewre)
        list.observe(viewLifecycleOwner, Observer {


            recycle.apply {
                layoutManager= LinearLayoutManager(context)

                }
            adapterr= listfragadaptoir(requireContext(),list.value!!){
                val bundle = Bundle()
                bundle.putInt("hello",it)
                findNavController().navigate(R.id.action_listfrag_to_plantInfo,bundle)}
            recycle.adapter = adapterr


        })
        val serachvieew = view.findViewById<SearchView>(R.id.searchView)
        serachvieew.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0 != null) {
                    viewmodel.filteredlistr = list.value!!.filter {
                        it.name.contains(p0, ignoreCase = true)
                    }
                    adapterr= listfragadaptoir(requireContext(), viewmodel.filteredlistr!!){
                        val bundle = Bundle()
                        bundle.putInt("hello",it)
                        findNavController().navigate(R.id.action_listfrag_to_plantInfo,bundle)}
                    recycle.adapter = adapterr
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0 != null) {
                    viewmodel.filteredlistr = list.value!!.filter {
                        it.name.contains(p0, ignoreCase = true)
                    }
                    adapterr= listfragadaptoir(requireContext(), viewmodel.filteredlistr!!){
                        val bundle = Bundle()
                        bundle.putInt("hello",it)
                        findNavController().navigate(R.id.action_listfrag_to_plantInfo,bundle)}
                    recycle.adapter = adapterr
                }
                return false
            }
        })
    }
}