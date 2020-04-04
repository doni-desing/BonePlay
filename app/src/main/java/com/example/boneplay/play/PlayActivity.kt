package com.example.boneplay.play

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.boneplay.R
import com.example.boneplay.result.ResultActivity
import com.iigo.library.DiceLoadingView
import com.iigo.library.DiceView
import kotlinx.android.synthetic.main.activity_play.*
import java.lang.Exception
import kotlin.random.Random

class PlayActivity : AppCompatActivity() {

    private var textView: TextView? = null
    private var textView1: TextView? = null
    private var tvResult1: TextView? = null
    private var tvResult2: TextView? = null
    private lateinit var diceView1: DiceView
    private lateinit var diceLoading: DiceLoadingView
    private lateinit var diceLoading2: DiceLoadingView
    private lateinit var diceView2: DiceView
    private var random: Random? = null
    private var array = arrayListOf<Int>()
    private var array2 = arrayListOf<Int>()
    var count = 0
    private var tv1 = ""
    private var tv2 = ""
    private var tv3 = ""
    private var tv4 = ""
    private var tv5 = ""


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        textView = findViewById(R.id.tv_payer_name1)
        tvResult1 = findViewById(R.id.tv_result_player1)
        tvResult2 = findViewById(R.id.tv_result_player2)
        textView1 = findViewById(R.id.tv_payer_name2)
        diceView1 = findViewById(R.id.dice1)
        diceView2 = findViewById(R.id.dice2)
        random = Random(1000)
        diceLoading = findViewById(R.id.diceL)
        diceLoading2 = DiceLoadingView(this)
        array.add(R.id.tv_result_player1)
        array.add(R.id.tv_result_player1_2)
        array.add(R.id.tv_result_player1_3)
        array.add(R.id.tv_result_player1_4)
        array.add(R.id.tv_result_player1_5)
        array2.add(R.id.tv_result_player2)
        array2.add(R.id.tv_result_player2_2)
        array2.add(R.id.tv_result_player2_3)
        array2.add(R.id.tv_result_player2_4)
        array2.add(R.id.tv_result_player2_5)

        tv_result_player1_2.visibility = View.INVISIBLE
        tv_result_player1_3.visibility = View.INVISIBLE
        tv_result_player1_4.visibility = View.INVISIBLE
        tv_result_player1_5.visibility = View.INVISIBLE
        setTextView()
    }

    private fun setTextView() {
        textView?.text = intent.getStringExtra("editText1")
        textView1?.text = intent.getStringExtra("editText2")
    }

    fun onClick1(view: View) {
        Log.d("plpl", " array1  "+ count)
        Log.d("plpl", " array2  " +  array2.size)

        if (count  == array2.size) {
            val intent = Intent(this, ResultActivity::class.java)
            if (tv_result1.text.toString() > tv_result2.text.toString()) {
                intent.putExtra("winner", tv_payer_name1.text.toString())
                intent.putExtra("count", tv_result1.text.toString())
            } else {
                intent.putExtra("winner2", tv_payer_name2.text.toString())
                intent.putExtra("count2", tv_result2.text.toString())

            }

            startActivity(intent)
            btn_play2.visibility = View.GONE

        } else {
            if (array.get(count) == R.id.tv_result_player1) {
                tvResult1!!.text = dice()
                tv_result_player1.visibility = View.VISIBLE
                tv_result_player1_2.visibility = View.VISIBLE
            }

            if (array.get(count) == R.id.tv_result_player1_2) {
                tv_result_player1_2!!.text = dice()
                tv_result_player1_3.visibility = View.VISIBLE
            }
            if (array.get(count) == R.id.tv_result_player1_3) {
                tv_result_player1_3!!.text = dice()
                tv_result_player1_4.visibility = View.VISIBLE

            }
            if (array.get(count) == R.id.tv_result_player1_4) {
                tv_result_player1_4!!.text = dice()
                tv_result_player1_5.visibility = View.VISIBLE
            }

            if (array.get(count) == R.id.tv_result_player1_5) {
                tv_result_player1_5!!.text = dice()
            }
        }

        showResultPlayer1()
        btn_play1.visibility = View.INVISIBLE
        if (count  == array2.size) {
            btn_play1.visibility = View.VISIBLE
        } else {
            btn_play2.visibility = View.VISIBLE
        }
        count++
    }

    private fun showResultPlayer1() {
        try {
            tv1 = (tv_result_player1!!.text.toString())

            if (array.get(count) == R.id.tv_result_player1_2) {
                tv2 = (tv_result_player1_2!!.text.toString())
            }
            if (array.get(count) == R.id.tv_result_player1_3) {
                tv3 = (tv_result_player1_3!!.text.toString())
            }
            if (array.get(count) == R.id.tv_result_player1_4) {
                tv4 = tv_result_player1_4!!.text.toString()
            }
            if (array.get(count) == R.id.tv_result_player1_5) {
                tv5 = tv_result_player1_5!!.text.toString()
            }
            val q1 = Integer.parseInt(tv1)
            val w2 = Integer.parseInt(tv2)
            val e3 = Integer.parseInt(tv3)
            val r4 = Integer.parseInt(tv4)
            val t5 = Integer.parseInt(tv5)
            val qwerty = q1.plus(w2).plus(e3).plus(r4).plus(t5)
            tv_result1.text = qwerty.toString()
        } catch (ex: Exception) {

        }
    }

    fun onClick2(view: View) {
        if (array2.get(count - 1) == R.id.tv_result_player2) {
            tv_result_player2!!.text = dice()
            tv_result_player2.visibility = View.VISIBLE
            tv_result_player2_2.visibility = View.VISIBLE

        }
        if (array2.get(count - 1) == R.id.tv_result_player2_2) {
            tv_result_player2_2!!.text = dice()
            tv_result_player2_3.visibility = View.VISIBLE

        }
        if (array2.get(count - 1) == R.id.tv_result_player2_3) {
            tv_result_player2_3!!.text = dice()
            tv_result_player2_4.visibility = View.VISIBLE

        }
        if (array2.get(count - 1) == R.id.tv_result_player2_4) {
            tv_result_player2_4!!.text = dice()
            tv_result_player2_5.visibility = View.VISIBLE

        }
        if (array2.get(count - 1) == R.id.tv_result_player2_5) {
            tv_result_player2_5!!.text = dice()

        }
        try {

            val tv21: String = (tv_result_player2!!.text.toString())

            val tv22 = (tv_result_player2_2!!.text.toString())

            val tv23 = (tv_result_player2_3!!.text.toString())

            val tv24 = tv_result_player2_4!!.text.toString()

            val tv25 = tv_result_player2_5!!.text.toString()

            val q1 = Integer.parseInt(tv21)
            val w2 = Integer.parseInt(tv22)
            val e3 = Integer.parseInt(tv23)
            val r4 = Integer.parseInt(tv24)
            val t5 = Integer.parseInt(tv25)
            val qwerty = q1.plus(w2).plus(e3).plus(r4).plus(t5)
            tv_result2.text = qwerty.toString()
        } catch (ex: Exception) {
        }
        btn_play2.visibility = View.INVISIBLE
        btn_play1.visibility = View.VISIBLE
    }

    private fun dice(): String {
        diceView1.number = (1..6).random()
        diceView2.number = (1..6).random()
        diceView1.visibility = View.VISIBLE
        diceView2.visibility = View.VISIBLE

        val num1 = Integer.parseInt(diceView1.number.toString())
        val num2 = Integer.parseInt(diceView2.number.toString())
        val count = num1.plus(num2)
        return count.toString()
    }

    fun start(view: View) {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}