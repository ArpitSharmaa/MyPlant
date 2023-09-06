package com.example.myplant

import android.content.Context
import android.util.Log

class repository(context: Context) {
    val database = Plantdatabase.getdatabase(context.applicationContext)
    val logindatabase = lofindatabase.getdatabaselogin(context.applicationContext)
    suspend fun insert(plantdata: List<plantdata>){
        database.getdao().insertdata(plantdata)
    }
    val dao = database.getdao()
    suspend fun get():List<plantdata>{
        return dao.getdata()
    }
    suspend fun insertlofin(lOGINDATAENTITY: lOGINDATAENTITY){
        logindatabase.getlogindata().insertnewuser(lOGINDATAENTITY)
    }
    val daologin = logindatabase.getlogindata()
    suspend fun userverfication(email:String):lOGINDATAENTITY?{
        Log.d("hello", "userverfication: called")
        val infios = daologin.getuserinfo(email)
        Log.d("hello", "userverfication: ${infios}")
        return infios
    }
}