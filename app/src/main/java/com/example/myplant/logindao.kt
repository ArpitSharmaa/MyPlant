package com.example.myplant

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query

@Dao
interface logindao {
    @Insert
    suspend fun insertnewuser (login:lOGINDATAENTITY)

    @Query("SELECT * FROM logindata WHERE email = :emaill")
    suspend fun getuserinfo (emaill:String): lOGINDATAENTITY?


}