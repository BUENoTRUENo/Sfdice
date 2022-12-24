package na.mytutorials.dicetuts.residentevil

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import na.mytutorials.dicetuts.databinding.ActivityResidentEvilShootingDiceBinding

class ResidentEvilShootingDiceActivity : AppCompatActivity() {

    companion object {
        fun startResidentEvilShootingDiceActivity(context: Context) {
            val intent = Intent(context, ResidentEvilShootingDiceActivity::class.java)
            context.startActivity(intent)
            println("tigo start shooting resident evil activity")
        }
    }
    val binding by lazy { ActivityResidentEvilShootingDiceBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}