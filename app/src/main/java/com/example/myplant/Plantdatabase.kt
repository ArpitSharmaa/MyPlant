package com.example.myplant

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [plantdata::class], version = 1)
@TypeConverters(Typeconvertor::class)
abstract class Plantdatabase: RoomDatabase() {

    abstract fun getdao(): plantdao

    companion object {
        @Volatile
        private var instance: Plantdatabase? = null
        fun getdatabase(context: Context): Plantdatabase{
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context.applicationContext, Plantdatabase::class.java, "Plantdatabse")
                            .build()
                }
            }
            return instance!!
        }
    }
}