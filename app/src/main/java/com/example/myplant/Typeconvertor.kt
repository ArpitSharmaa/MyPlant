package com.example.myplant

import androidx.room.TypeConverter
import androidx.room.TypeConverters

@TypeConverters
class Typeconvertor {
    @TypeConverter
    fun fromstring(string: String):List<String>{
        return string.split(",")
    }
    @TypeConverter
    fun tostring(list: List<String>):String{
        return list.joinToString(",")
    }
}