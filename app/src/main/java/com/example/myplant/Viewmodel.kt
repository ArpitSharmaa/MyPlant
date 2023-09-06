package com.example.myplant

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.*
import kotlinx.coroutines.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class Viewmodel(val context:Context): ViewModel(){
    val repository = repository(context.applicationContext)
    var listofdata = MutableLiveData<List<plantdata>>()
    var filteredlistr : List<plantdata>? = null
    val livelist : LiveData<List<plantdata>>
            get() = listofdata
    var reallist: List<plantdata>? = null
    fun getlist() {
        viewModelScope.launch {
          reallist=   repository.get()
        }
        listofdata.value = reallist
    }
    fun insertdatatoroom(plantdata: List<plantdata>){
        viewModelScope.launch {
            repository.insert(plantdata)
        }
    }
    val services = retrofitservice.service
    val livedata = MutableLiveData<PlantNetResponse>()
    var datafetch :PlantNetResponse? = null
     @SuppressLint("SuspiciousIndentation", "SetTextI18n")
     fun getdata(part:MultipartBody.Part, button: Button,lifecycleOwner: LifecycleOwner){
//        Log.d("hello", "getdata:${part} ")
        datafetch = null
        viewModelScope.launch {
            withContext(Dispatchers.Main){
              val response=  call(part)
                Log.d("hello", "getdata: ${response.body()}")
                datafetch= response.body()
                button.text = "tap"
            }
        }
         livedata.value= datafetch
         button.visibility = View.VISIBLE







    }
    suspend fun call(part: MultipartBody.Part):Response<PlantNetResponse>{
        val response = viewModelScope.async (Dispatchers.IO){
            services.identifyPlant(api_key,part)
        }
        val responsemain = response.await()
        return responsemain
    }
    // login user

    fun newuser(lOGINDATAENTITY: lOGINDATAENTITY){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.insertlofin(lOGINDATAENTITY)
                Log.d("hello", "newuser: functioncalled")
            }
        }
    }


    var inform:lOGINDATAENTITY?=null
    fun getexistinguser(email:String):lOGINDATAENTITY?{
//        viewModelScope.launch(Dispatchers.IO){
//
//            inform =repository.userverfication(email)
//            Log.d("hello", "getexistinguser: ${inform}")
//        }
        runBlocking {
            inform =repository.userverfication(email)
        }

        return inform
    }
}


