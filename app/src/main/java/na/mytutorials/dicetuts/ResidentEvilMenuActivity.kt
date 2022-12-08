package na.mytutorials.dicetuts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import na.mytutorials.dicetuts.ResidentEvilMenuActivity.Companion.startResidentEvilMenuActivity
import na.mytutorials.dicetuts.databinding.ActivityResidentEvilMenuBinding
import na.mytutorials.dicetuts.databinding.ActivityResidentEvilShootingDiceBinding

class ResidentEvilMenuActivity : AppCompatActivity() {
    //1. Finish the UI to have 3 different options Dodge, Attack, Enter Room. Done
    //I finished adding the images and created ids for each image button. Done

    //2. Work on entering room Activity and Logic ( 1-6 Umbrella Dice) Done
    //3. Create a dialog pop up asking " How many dice?" (Example) Done
    //4.Create Activity for shooting ( 2 Push back per dice, 1 Hit Point per dice) Done.
    //5. Create Activity for dodge ( 3 dodges per dice) Done.


    companion object {
        fun startResidentEvilMenuActivity(context: Context) {
            val intent = Intent(context, ResidentEvilMenuActivity::class.java)
            context.startActivity(intent)
        }
    }

    val binding by lazy { ActivityResidentEvilMenuBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initListener()
    }

    fun initListener(){
        binding.shootingMenuButton.setOnClickListener {
            ResidentEvilShootingDiceActivity.startResidentEvilShootingDiceActivity(this@ResidentEvilMenuActivity)
        }
        binding.dodgeMenuButton.setOnClickListener {
            ResidentEvilDodgeMenuActivity.startResidentEvilDodgeMenuActivity(this@ResidentEvilMenuActivity)
        }
        binding.openDoorMenuButton.setOnClickListener{
            ResidentEvilEnterRoomActivity.startResidentEvilEnterRoomActivity(this@ResidentEvilMenuActivity)
        }
    }

}