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

    var db = App.instance.getResult()

    suspend fun getResult(): List<ResultModel>? {
        return db.saveResult().getResult()
    }

    fun insertResult(model: ResultModel) {
        uiScope.launch {
            db.saveResult().insertResult(model)
        }
    }
}