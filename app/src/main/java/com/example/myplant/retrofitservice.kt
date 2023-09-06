package com.example.myplant

import android.net.Uri
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*


// https://plant.id/api/v2
val api_key= "2b10YmvKi0MsLl3FasOiq4bPoO"
private val base_url = "https://plant.id/api/v2/"
interface retrofitservice{


        @Multipart
        @POST("identify/all")
        suspend fun identifyPlant(
            @Query("api-key") apikey :String,
            @Part image: MultipartBody.Part
        ): Response<PlantNetResponse>

    companion object{


        private val client = OkHttpClient.Builder()
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://my-api.plantnet.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val service: retrofitservice = retrofit.create(retrofitservice::class.java)
    }
}
