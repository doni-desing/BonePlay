package com.example.boneplay.onBoard

import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.boneplay.R

public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
var image: ImageView = itemView.findViewById(R.id.img)
    public fun onBind(position: Int){
        when(position){
            0 ->{
                image.setImageResource(R.drawable.img_dice)

            }
            1 ->{
                image.setImageResource(R.drawable.dice_image2)
            }
        }
    }

}
