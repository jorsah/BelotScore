package com.foreachsoft.blotscore

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var isBoy = false
        var x: Int
        var p1 = Player(0)
        var p2 = Player(0)

        x1_save.setOnClickListener {
            x = x_add.text.toString().toInt()
            p1 = Player(x)
            p2 = Player(x)
            p1.b = true
            isBoy = boy.isChecked
        }

        x2_save.setOnClickListener {
            x = x_add.text.toString().toInt()
            p1 = Player(x)
            p2 = Player(x)
            p2.b = true
            isBoy = boy.isChecked
        }

        ok_btn.setOnClickListener {
            fun a() {
                p1.z = 0; p2.z = 0
                if (!else_add1.text.isNullOrEmpty()) p1.z = else_add1.text.toString().toInt()
                if (!else_add2.text.isNullOrEmpty()) p2.z = else_add2.text.toString().toInt()

                val b1 = switch1.isChecked
                val b2 = switch2.isChecked
                val clc: CalculatingClass
                if (p1.b) {
                    p2.y = their_add.text.toString().toIntOrNull()
                    clc = CalculatingClass(p1, p2)
                    val p = check(clc, b1, b2, isBoy)

                    val intent = Intent()
                    intent.putExtra("score_1", p.first.t)
                    intent.putExtra("score_2", p.second.t)
                    intent.putExtra("score_x", p.first.x)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else {
                    p1.y = their_add.text.toString().toIntOrNull()
                    clc = CalculatingClass(p2, p1)
                    val p = check(clc, b1, b2, isBoy)

                    val intent = Intent()
                    intent.putExtra("score_1", p.second.t)
                    intent.putExtra("score_2", p.first.t)
                    intent.putExtra("score_x", p.first.x)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
            if(p1.x > 8){
                a()
            }
        }
    }

    private fun check(
        clc: CalculatingClass,
        b1: Boolean,
        b2: Boolean,
        isBoy: Boolean
    ): Pair<Player, Player> {
        return if (clc.isLose()) {
            if (isBoy) {
                clc.defBLoseScore(b1, b2)
            } else {
                clc.defLoseScore(b1, b2)
            }
        } else {
            if (isBoy) {
                clc.winB(b1, b2)
            } else {
                clc.win(b1, b2)
            }
        }
    }
}