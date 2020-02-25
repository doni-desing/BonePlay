package com.example.boneplay.db
import androidx.room.Database
import com.example.boneplay.model.ResultModel
import androidx.room.RoomDatabase

@Database(entities = [ResultModel::class], version = 1, exportSchema = false)
abstract class ResultDataBase: RoomDatabase() {
abstract fun saveResult() : RoomMethod
}