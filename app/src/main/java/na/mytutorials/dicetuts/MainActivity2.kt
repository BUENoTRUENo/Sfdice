package na.mytutorials.dicetuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.system.Os.kill
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity2 : AppCompatActivity() {
    var ourDice = 0
  var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        lateinit var timer: CountDownTimer

        val moveButton = findViewById<Button>(R.id.makeMove)
        var textOne = findViewById<TextView>(R.id.timeTV)
        var number = 31
        val numberOfDiceText = findViewById<EditText>(R.id.dice_edit_text)

        numberOfDiceText.addTextChangedListener {
            val somthing = it.toString()
            if (somthing.length > 0) {
                ourDice = if (somthing.toInt() < 7) somthing.toInt() else 6
            }
            Log.d("miko", "it is $somthing")
            Log.d("miko", "size ${somthing.length}")
        }
        val nextMoveButton = findViewById<Button>(R.id.next_move)
        nextMoveButton.setOnClickListener {
            DiceActivity.startDiceActivity(ourDice, this@MainActivity2)
        }
        // some more new stuff

        moveButton.setOnClickListener {
            number = 61

            if (count > 0) {
                timer.cancel()
            } else {
                count += 1
            }

            timer = object : CountDownTimer(61000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    if (number > 0) {
                        number -= 1

                        textOne.text = "$number"
                    }
                }

                override fun onFinish() {

                    print(2)
                        cancel()
                    number = 61
                }

            }


            timer.start()
        }
    }


}

