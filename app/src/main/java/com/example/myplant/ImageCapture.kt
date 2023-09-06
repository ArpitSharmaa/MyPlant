package com.example.myplant

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.core.content.FileProvider
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.*


class ImageCapture : Fragment() {
    val IMAGE_REQUEST_CODE = 100
    lateinit var imgviw:ImageView
    var imageuri:Uri ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageuri = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_image_capture, container, false)
        val uri= createimguri()
        imageuri= null

        imgviw= view.findViewById<ImageView>(R.id.imageView3)
        val buttom = view.findViewById<Button>(R.id.button)
        val newimg = view.findViewById<Button>(R.id.button3)
        val delete = view.findViewById<Button>(R.id.delete)
        val search = view.findViewById<Button>(R.id.button2)
        val galarybut = view.findViewById<Button>(R.id.Galary)
        val button = view.findViewById<Button>(R.id.button4)
        button.visibility = View.INVISIBLE
        imgviw.setImageURI(imageuri)
        delete.visibility=View.INVISIBLE
        newimg.visibility= View.INVISIBLE
        val contracttwo = registerForActivityResult(ActivityResultContracts.GetContent()){
            imgviw.setImageURI(it)
            imageuri = it
        }
        val contract = registerForActivityResult(ActivityResultContracts.TakePicture()){
            imgviw.setImageURI(null)
            imgviw.setImageURI(uri)
            imageuri = uri
            buttom.visibility= View.INVISIBLE
            newimg.visibility= View.VISIBLE
            delete.visibility= View.VISIBLE
        }

        galarybut.setOnClickListener {
            contracttwo.launch("image/*")
            buttom.visibility= View.INVISIBLE
        }
        buttom.setOnClickListener {
            contract.launch(uri)

        }
        newimg.setOnClickListener {
            contract.launch(uri)
        }
        delete.setOnClickListener {
            imgviw.setImageURI(null)
            imageuri= null
        }
        search.setOnClickListener {
            if (imageuri == null){
                Toast.makeText(context, "Please Insert Image", Toast.LENGTH_SHORT).show()
            }else {
                val filedir = context?.filesDir
                val file = File(filedir, "image.png")

                val outputStream = FileOutputStream(file)
                context?.contentResolver?.openInputStream(imageuri!!)?.copyTo(outputStream)
                val requestbody = file.asRequestBody("image/*".toMediaTypeOrNull())
                val part = MultipartBody.Part.createFormData("images", file.name, requestbody)
                viewmodel.getdata(part, button, viewLifecycleOwner)
                search.visibility = View.INVISIBLE
            }

        }
        button.setOnClickListener {
            if (button.text == "wait") {
                Toast.makeText(context, "Please wait while fetching result", Toast.LENGTH_SHORT)
                    .show()
            } else {
                findNavController().navigate(R.id.action_imageCapture_to_resultlist)
            }
            search.visibility = View.INVISIBLE
        }
        return view
    }


    fun createimguri(): Uri? {
        val img = File(requireContext().filesDir,"camera.png")
        return context?.let { FileProvider.getUriForFile(it,"com.example.myplant.fileprovider",img) }
    }
    fun onclicgalary(){
        val galarybut = requireView().findViewById<Button>(R.id.Galary)
        galarybut.performClick()
       }


}
