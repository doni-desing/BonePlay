package com.example.boneplay.main

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.boneplay.play.PlayActivity
import com.example.boneplay.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.BASE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "You are sure want comes out this app", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "You are sure want out this app", Toast.LENGTH_LONG).show()
    }

    fun onClick(view: View) {
        if(et_1.text.isNullOrEmpty()&& et_2.text.isNullOrEmpty()){
            et_1.error = "Write data"

            et_2.error = "Write data"
        } else {
            intent()
        }
    }
    private fun intent(){
        val intent = Intent(this, PlayActivity::class.java)
        intent.putExtra("editText1", et_1.text.toString())
        intent.putExtra("editText2", et_2.text.toString())
        startActivity(intent)
    }
}
