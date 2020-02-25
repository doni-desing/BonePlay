package com.example.boneplay.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.boneplay.model.ResultModel
@Dao
interface RoomMethod {
    @Insert
    suspend fun insertResult(model: ResultModel)

    @Query("SELECT * FROM result_model")
    suspend fun getResult(): List<ResultModel>

}