package com.example.boneplay.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boneplay.R
import com.example.boneplay.model.ResultModel
import com.example.boneplay.result.adapter.ResultAdapter
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultActivity : AppCompatActivity() {
    private var viewModel: ResultViewModel? = null
    private lateinit var adapter: ResultAdapter
    private var recyclerView: RecyclerView? = null
    private var winner: String? = null
    private var winner2: String? = null
    private var count: String? = null
    private var count2: String? = null
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        winner = intent.getStringExtra("winner")
        count = intent.getStringExtra("count")
        winner2 = intent.getStringExtra("winner2")
        count2 = intent.getStringExtra("count2")

        viewModel = ViewModelProviders.of(this).get(ResultViewModel::class.java)
        adapter = ResultAdapter()
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(applicationContext)
        subscribeToViewModel()

    }
    private fun subscribeToViewModel() {
        CoroutineScope(Dispatchers.Main).launch {
            val model = viewModel?.getResult()
            if (winner != null || winner2 != null || model == null) {
                updateDatabase()
            } else if (model != null) {
                adapter.upDataAdapter(model!!)
            }
        }
        id++
    }

    private fun updateDatabase() {
        if (count.isNullOrEmpty()) {
            viewModel?.insertResult(ResultModel( winner2.toString(), count2))
            adapter.addResult(ResultModel( winner2.toString(), count2))

        } else {
            viewModel?.insertResult(ResultModel( winner.toString(), count))
            adapter.addResult(ResultModel(winner.toString(), count))

        }
    }

}
