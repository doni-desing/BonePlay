package com.example.boneplay.onBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.boneplay.main.MainActivity
import com.example.boneplay.R
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        viewPager2.adapter = AdapterViewPager()
        viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL

    }

    fun clickNext(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
