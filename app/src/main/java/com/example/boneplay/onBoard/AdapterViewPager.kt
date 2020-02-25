package com.example.boneplay.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.boneplay.R

class AdapterViewPager : RecyclerView.Adapter<ViewHolder>() {
    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager2, parent, false))
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }
}