package com.example.boneplay

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.room.Room
import com.example.boneplay.db.ResultDataBase

@SuppressLint("Registered")
class App : Application() {
    companion object {
        lateinit var instance: App
         var dataBase: ResultDataBase? = null
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d("ololol", "onCreate")
        dataBase = Room.databaseBuilder(this, ResultDataBase::class.java, "database")
            .build()

    }

    fun getResult(): ResultDataBase {
        return dataBase!!
    }
}