package com.example.boneplay.result.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.boneplay.R
import com.example.boneplay.model.ResultModel

class ResultAdapter : RecyclerView.Adapter<ResultViewHolder>() {

    private var list: ArrayList<ResultModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate( R.layout.item_result_recycler_view, parent,false)
        return ResultViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.onBind(list)
    }
    fun upDataAdapter(list: List<ResultModel>){
        this.list = list as ArrayList<ResultModel>
        notifyDataSetChanged()
    }
    fun addResult(list2: ResultModel){
        list.add(list2)
        notifyDataSetChanged()
    }
}