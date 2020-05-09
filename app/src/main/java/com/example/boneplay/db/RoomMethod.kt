package com.example.boneplay.db

import android.icu.text.Replaceable
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.boneplay.model.ResultModel
@Dao
interface RoomMethod {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(list: ResultModel)

    @Query("SELECT * FROM result_model")
    suspend fun getResult(): List<ResultModel>

}