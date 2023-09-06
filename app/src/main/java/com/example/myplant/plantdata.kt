package com.example.myplant

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Plantsdata")
data class plantdata(
    @PrimaryKey(autoGenerate = true) val id :Long,
    val name:String,
    val image :String,
    val Common_names : List<String>,
    val taxanomy : String,
)
