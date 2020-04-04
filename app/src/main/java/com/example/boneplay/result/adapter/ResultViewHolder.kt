package com.example.boneplay.result.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.boneplay.R
import com.example.boneplay.model.ResultModel

class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var winnerPlayer: TextView = itemView.findViewById(R.id.tv_result_winner)
    private var count: TextView = itemView.findViewById(R.id.tv_winner_count)

    fun onBind(list: List<ResultModel>){
        winnerPlayer.text = list.get(0).winner
        count.text = list.get(0).sum


    }

}
