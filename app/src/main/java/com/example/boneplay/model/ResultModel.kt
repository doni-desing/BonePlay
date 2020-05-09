package com.example.boneplay.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_model")
data class ResultModel(
    @PrimaryKey
    var winner: String,
    var sum: String?
)