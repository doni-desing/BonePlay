package com.example.boneplay.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_model")
data class ResultModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var winner: String,
    var sum: String?
)