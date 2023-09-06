package com.example.myplant

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [lOGINDATAENTITY::class], version = 1)
abstract class lofindatabase:RoomDatabase() {
    abstract fun getlogindata():logindao

    companion object{
        @Volatile
        private var instance:lofindatabase? = null
        fun getdatabaselogin (context:Context):lofindatabase{
            if (instance==null){
                synchronized(this){
                    instance= Room.databaseBuilder(context.applicationContext,lofindatabase::class.java,"lofindatabase").build()

                }
            }
            return instance!!
        }
    }
}