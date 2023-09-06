package com.example.myplant

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface plantdao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertdata(list: List<plantdata>)

    @Query("SELECT * FROM Plantsdata")
    suspend fun getdata():List<plantdata>
}