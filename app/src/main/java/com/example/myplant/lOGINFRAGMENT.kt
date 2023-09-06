package com.example.myplant

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.fragment.findNavController

class lOGINFRAGMENT : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var  email:TextView
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_l_o_g_i_n_f_r_a_g_m_e_n_t, container, false)
        val login = view.findViewById<Button>(R.id.login)
        val signup = view.findViewById<Button>(R.id.signup)
        email = view.findViewById<TextView>(R.id.editTextTextEmailAddress)
        val pass = view.findViewById<TextView>(R.id.editTextTextPassword)
        email.text = ""
        pass.text=""
        login.setOnClickListener {
            if (email.text.isBlank() || pass.text.isBlank()){
                Toast.makeText(context, "please insert credentials", Toast.LENGTH_SHORT).show()
            }else if (isValidEmail(email.text.toString())){
                val user = viewmodel.getexistinguser(email.text.toString())
                if (user == null) {
                    Toast.makeText(context, "Please enter the verified email ", Toast.LENGTH_SHORT)
                        .show()
                } else if (user.password == pass.text.toString()) {
                    findNavController().navigate(R.id.action_lOGINFRAGMENT_to_searchByNameFragment)
                }
            }else{
                email.setError("invalide fromat")
//                Toast.makeText(context, "Wrong email format", Toast.LENGTH_SHORT).show()
//                email.setBackgroundColor(Color.RED)
            }
        }
        signup.setOnClickListener {
            if (email.text.isBlank() || pass.text.isBlank()){
                Toast.makeText(context, "please insert credentials", Toast.LENGTH_SHORT).show()
            }else if (isValidEmail(email.text.toString())){
                val user = viewmodel.getexistinguser(email.text.toString())
                if (user==null){
                    val newuser = lOGINDATAENTITY(email.text.toString(),pass.text.toString())
                    viewmodel.newuser(newuser)
                    Log.d("hello", "onViewCreated:${newuser} ")
                    email.text=""
                    pass.text=""
                }else{
                    Toast.makeText(context, "already a user", Toast.LENGTH_SHORT).show()
                }
            }else{
                email.setError("invalid format")
            }
        }
        return view
    }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^([\\w\\d\\.-]+)@([\\w\\d\\.-]+)\\.([a-z]{2,})$")
        return emailRegex.matches(email)
    }
}