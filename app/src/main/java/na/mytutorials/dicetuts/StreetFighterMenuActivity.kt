package na.mytutorials.dicetuts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import na.mytutorials.dicetuts.databinding.ActivityStreetFighterMenuBinding

class StreetFighterMenuActivity : AppCompatActivity() {

    companion object {
        fun startStreetFighterMenuActivity(context: Context) {
            val intent = Intent(context, StreetFighterMenuActivity::class.java)
            context.startActivity(intent)
        }
    }

    var ourDice = 0
    var count = 0
    val binding by lazy { ActivityStreetFighterMenuBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lateinit var timer: CountDownTimer

        var number = 31


        binding.diceEditTextview.addTextChangedListener {
            val somthing = it.toString()
            if (somthing.length > 0) {
                ourDice = if (somthing.toInt() < 7) somthing.toInt() else 6
            }
            Log.d("miko", "it is $somthing")
            Log.d("miko", "size ${somthing.length}")
        }
        binding.nextMoveButton.setOnClickListener {
            DiceActivity.startDiceActivity(ourDice, this@StreetFighterMenuActivity)
        }
        // some more new stuff

        binding.moveButton.setOnClickListener {
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

                        binding.timeTextview.text = "$number"
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

