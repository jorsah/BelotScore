package com.foreachsoft.blotscore

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list1 = mutableListOf<Int>()
    private val list2 = mutableListOf<Int>()
    var sum1 = 0;var sum2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        add_btn.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)
            startActivityForResult(intent,100)
        }

        dlt_btn.setOnClickListener {
            p1_score.text = ""
            p2_score.text = ""
            x_score.text = ""
            sum1 = 0; sum2 = 0
            list1.clear()
            list2.clear()
            wf.text = "0"
            tf.text = "0"
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK){
            p1_score.text ="${p1_score.text}${data?.getIntExtra("score_1",0).toString()}\n"
            p2_score.text = "${p2_score.text}${data?.getIntExtra("score_2",0).toString()}\n"
            x_score.text = "${x_score.text}${data?.getIntExtra("score_x",0).toString()}\n"
            list1.add(data?.getIntExtra("score_1",0)!!)
            list2.add(data?.getIntExtra("score_2",0)!!)
            sum1 = list1.sum()
            sum2 = list2.sum()
            wf.text = sum1.toString()
            tf.text = sum2.toString()
        }
    }

}