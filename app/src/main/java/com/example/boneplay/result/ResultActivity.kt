package com.example.boneplay.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.boneplay.R
import com.example.boneplay.result.adapter.ResultAdapter
import ir.androidexception.datatable.DataTable

class ResultActivity : AppCompatActivity() {
    lateinit var adapter:  ResultAdapter
    var recyclerView2: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        adapter = ResultAdapter()
        recyclerView2 = findViewById(R.id.recycler_view)
    }

}
