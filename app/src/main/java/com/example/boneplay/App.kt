package com.example.boneplay

import android.app.Application
import androidx.room.Room
import com.example.boneplay.db.ResultDataBase

class App : Application() {
    companion object {
        lateinit var dataBase: ResultDataBase
        lateinit var instance: App
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        dataBase = Room.databaseBuilder(this, ResultDataBase::class.java, "database")
            .build()
    }
    fun getInstance():App{
        return instance
    }


    fun getResult(): ResultDataBase {
        return dataBase
    }
}