package com.example.boneplay.result

import androidx.lifecycle.ViewModel
import com.example.boneplay.App

import com.example.boneplay.model.ResultModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var db = App.dataBase

    suspend fun getResult(id: Int): List<ResultModel>? {
        return db?.saveResult()?.getResult(id)
    }

    fun insertResult(list: ResultModel) {
        uiScope.launch {
            db?.saveResult()?.insertResult(list)
        }
    }
}