package com.example.myplant

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.runBlocking


class SearchByNameFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_search_by_name, container, false)
        val imgcap = ImageCapture()
        val navigationView = view.findViewById<NavigationView>(R.id.navigation)
        val drawerLayout = view.findViewById<DrawerLayout>(R.id.draw)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            activity, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        val button = view.findViewById<ImageButton>(R.id.open_drawer)
        button.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.captureimg -> {
                    findNavController().navigate(R.id.action_searchByNameFragment_to_imageCapture)

                     true
                }
                R.id.searchindatabase-> {
                    viewmodel.getlist()
                    findNavController().navigate(R.id.action_searchByNameFragment_to_listfrag)
                true}
                R.id.upload-> {
                    findNavController().navigate(R.id.action_searchByNameFragment_to_imageCapture)
                    true
                }
                R.id.logout->{
                    findNavController().navigate(R.id.action_searchByNameFragment_to_lOGINFRAGMENT)
                    true}
                else -> {true}
            }
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttontodatabase = view.findViewById<Button>(R.id.button5)
        val buttontocap = view.findViewById<Button>(R.id.button6)
//        val draawable = GradientDrawable()
//        draawable.cornerRadius= 50f
//        draawable.shape = GradientDrawable.RECTANGLE
//        buttontocap.background=draawable
//        buttontodatabase.background=draawable
//        buttontodatabase.textAlignment= View.TEXT_ALIGNMENT_TEXT_START
        buttontodatabase.setOnClickListener {
            viewmodel.getlist()
            findNavController().navigate(R.id.action_searchByNameFragment_to_listfrag)
        }
        buttontocap.setOnClickListener {
            findNavController().navigate(R.id.action_searchByNameFragment_to_imageCapture)
        }
//        val navController = findNavController(R.id.contentFrame)


    }
}