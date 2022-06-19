package na.mytutorials.dicetuts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DiceActivity : AppCompatActivity() {


    var numberOfDice=0
    var d1 = -1
    var d2 = -1
    var d3 = -1
    var d4 = -1
    var d5 = -1
    var d6 = -1
    private val minForCrit = 4

    private val dieCards = listOf(
        R.drawable.purplebigfist,
        R.drawable.purplebigshield,
        R.drawable.purpledoublefist,
        R.drawable.purpleenergy,
        R.drawable.purpleshieldfist,
        R.drawable.purpleshieldfist
    )

    val critPhysicalWorthy = listOf(0, 2, 4, 5)
    val critManaWorthy = listOf(3, 3, 3)

    lateinit var rollingOne: ImageView
    lateinit var rollingTwo: ImageView
    lateinit var rollingThree: ImageView
    lateinit var rollingFour: ImageView
    lateinit var rollingFive: ImageView
    lateinit var rollingSix: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setCorrectScreen(intent))

        var byuton: Button = findViewById(R.id.superButton)
        rollingOne = findViewById(R.id.diceOne)
        rollingTwo = findViewById(R.id.diceTwo)
        rollingThree = findViewById(R.id.diceThree)
        rollingFour = findViewById(R.id.diceFour)
        rollingFive = findViewById(R.id.diceFive)
        rollingSix = findViewById(R.id.diceSix)

        byuton.setOnClickListener {

            val timer = object : CountDownTimer(1000, 200) {
                override fun onTick(millisUntilFinished: Long) {
                    setMyDiceAndSaveMyValue(1)
                    setMyDiceAndSaveMyValue(2)
                    setMyDiceAndSaveMyValue(3)
                    setMyDiceAndSaveMyValue(4)
                    setMyDiceAndSaveMyValue(5)
                    setMyDiceAndSaveMyValue(6)
                    rollCorrectNumberOfDice()


                }

                override fun onFinish() {
                    playerOneCheckForHits()
                    playerTwoCheckForHits()
                    print(2)
                }

            }
            timer.start()

        }
    }

    private fun rollCorrectNumberOfDice() {
        when (numberOfDice) {
            1 -> {
                setOneDice()
            }
            2 -> {
                setTwoDice()
            }
            3 -> {
                setThreeDice()
            }
            4 -> {
                setFourDice()
            }
            5 -> {
                setFiveDice()
            }
            6 -> {
                setAllDice()
            }
            else -> {
                setOneDice()
            }
        }
    }

    private fun setCorrectScreen(intent: Intent?): Int {
        val myExtra = intent?.extras
        numberOfDice  = intent?.extras?.getInt(MY_DICE_KEY, 6) ?: 6
        return when (numberOfDice) {
            1 -> {
            R.layout.single_dice_layout
            }
            2 -> {
            R.layout.two_dice_layout
            }
            3 -> {
            R.layout.three_dice_layout
            }
            4 -> {
            R.layout.four_dice_activity
            }
            5 -> {
            R.layout.five_dice_layout
            }
            6 -> {
                R.layout.activity_six_dice
            }
            else -> {
                R.layout.single_dice_layout
            }
        }
    }

    private fun setAllDice() {
        setMyDiceAndSaveMyValue(1)
        setMyDiceAndSaveMyValue(2)
        setMyDiceAndSaveMyValue(3)
        setMyDiceAndSaveMyValue(4)
        setMyDiceAndSaveMyValue(5)
        setMyDiceAndSaveMyValue(6)
    }

    private fun setFiveDice() {
        setMyDiceAndSaveMyValue(1)
        setMyDiceAndSaveMyValue(2)
        setMyDiceAndSaveMyValue(3)
        setMyDiceAndSaveMyValue(4)
        setMyDiceAndSaveMyValue(5)
    }

    private fun setFourDice() {
        setMyDiceAndSaveMyValue(1)
        setMyDiceAndSaveMyValue(2)
        setMyDiceAndSaveMyValue(3)
        setMyDiceAndSaveMyValue(4)
    }

    private fun setThreeDice() {
        setMyDiceAndSaveMyValue(1)
        setMyDiceAndSaveMyValue(2)
        setMyDiceAndSaveMyValue(3)
    }

    private fun setTwoDice() {
        setMyDiceAndSaveMyValue(1)
        setMyDiceAndSaveMyValue(2)
    }

    private fun setOneDice() {
        setMyDiceAndSaveMyValue(1)
    }

    private fun setMyDiceAndSaveMyValue(diceImageViewPosition: Int) {

        val myRandomDiceNumber = getRandomDiceImage()

        when (diceImageViewPosition) {
            1 -> {
                val targetImage = dieCards[myRandomDiceNumber]
                rollingOne.setImageResource(targetImage)
                d1 = myRandomDiceNumber
            }
            2 -> {
                val targetImage = dieCards[myRandomDiceNumber]
                rollingTwo.setImageResource(targetImage)
                d2 = myRandomDiceNumber

            }
            3 -> {
                val targetImage = dieCards[myRandomDiceNumber]
                rollingThree.setImageResource(targetImage)
                d3 = myRandomDiceNumber

            }
            4 -> {
                val targetImage = dieCards[myRandomDiceNumber]
                rollingFour.setImageResource(targetImage)
                d4 = myRandomDiceNumber

            }
            5 -> {
                val targetImage = dieCards[myRandomDiceNumber]
                rollingFive.setImageResource(targetImage)
                d5 = myRandomDiceNumber

            }
            6 -> {
                val targetImage = dieCards[myRandomDiceNumber]
                rollingSix.setImageResource(targetImage)
                d6 = myRandomDiceNumber

            }
            else -> {

            }
        }

    }

    fun getRandomDiceImage(): Int {

        val minNumber = 0

        val maxNumber = dieCards.size - 1

        return (minNumber..maxNumber).random()
    }

    fun playerOneCheckForHits() {

        val myCritList = ArrayList<Boolean>()

        myCritList.add(critPhysicalWorthy.contains(d1))
        myCritList.add(critPhysicalWorthy.contains(d2))
        myCritList.add(critPhysicalWorthy.contains(d3))
        myCritList.add(critPhysicalWorthy.contains(d4))
        myCritList.add(critPhysicalWorthy.contains(d5))
        myCritList.add(critPhysicalWorthy.contains(d6))


        var myImageCount = 0
        myCritList.forEach {
            if (it) {
                myImageCount++
            }
        }

        val critNoise = (myImageCount > minForCrit)

        if (critNoise) {
            showCritStuff(1)
        }

        // mana logic
    }

    fun playerTwoCheckForHits() {

    }

    private fun showCritStuff(player: Int) {
        Toast.makeText(this, "Player $player Just Critted Bitch", Toast.LENGTH_SHORT).show()
    }

    private fun showManaCritStuff() {
        Toast.makeText(this, "Energy!", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun startDiceActivity(numOfDice: Int, context: Context) {
            val intent = Intent(context, DiceActivity::class.java)
            intent.putExtra(MY_DICE_KEY, numOfDice)
            context.startActivity(intent)
        }

        const val MY_DICE_KEY = "my dice key"
    }


}
