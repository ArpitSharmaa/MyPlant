package com.example.myplant

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logindata")
data class lOGINDATAENTITY(
    @PrimaryKey val email:String,
    val password :String
)
