package na.mytutorials.dicetuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import na.mytutorials.dicetuts.databinding.ActivitySelectGameModeRemakeBinding
import na.mytutorials.dicetuts.residentevil.ResidentEvilMenuActivity
import na.mytutorials.dicetuts.streetfighter.StreetFighterMenuActivity

const val SF_LOGO = R.drawable.sflogosf
const val RESIDENTEVIL_LOGO = R.drawable.rebigbrella

class SelectGameModeRemakeActivity : AppCompatActivity() {

    val binding by lazy { ActivitySelectGameModeRemakeBinding.inflate(layoutInflater) }
    private var isStreetFighter = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.selectGameTypeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val id = if (isChecked) SF_LOGO else RESIDENTEVIL_LOGO
            val logo = getDrawable(id)
            isStreetFighter = isChecked
            binding.mainLogoImageview.background = logo
        }

        binding.mainLogoImageview.setOnClickListener {
            if (isStreetFighter) launchStreetFighter() else launchResidentEvil()
        }
    }

    private fun launchStreetFighter() {
        StreetFighterMenuActivity.startStreetFighterMenuActivity(this@SelectGameModeRemakeActivity)
    }

    private fun launchResidentEvil() {
        ResidentEvilMenuActivity.startResidentEvilMenuActivity(this@SelectGameModeRemakeActivity)
    }
}