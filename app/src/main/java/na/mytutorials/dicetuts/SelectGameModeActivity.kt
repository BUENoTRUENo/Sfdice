package na.mytutorials.dicetuts

import android.content.ClipData.newIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import android.widget.Toast
import na.mytutorials.dicetuts.databinding.ActivitySelectGameModeBinding


class SelectGameModeActivity : AppCompatActivity() {

    companion object {
        fun startSelectGameModeActivity(context: Context) {
            val intent = Intent(context, SelectGameModeActivity::class.java)
            context.startActivity(intent)
        }
    }


    lateinit var switchForSf: Switch
    lateinit var sfButton: ImageButton
    lateinit var reButton: ImageButton
    var isReady: Boolean = false
    val binding by lazy { ActivitySelectGameModeBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        println("tigo starting onCreate")

        initListener()
    }

    fun initListener() {
        println("tigo start of initListener")
        binding.selectGameTypeSwitch.setOnCheckedChangeListener { sw, isChecked ->
            println("tigo switch checkChangeListener $isChecked")
            isReady = isChecked
            simpleToast("Switch is toggled $isReady   realvalue=$isChecked")
        }

        binding.streetfighterLogoImageview.setOnClickListener {
            simpleToast("street fighter  CLICKED $isReady")
            println("tigo switch clickListener")

            if (!isReady) {
                simpleToast("street fighter UNLOCKED $isReady")
                StreetFighterMenuActivity.startStreetFighterMenuActivity(this@SelectGameModeActivity)
            }

        }

        binding.residentEvilUmbrellaImageview.setOnClickListener {
            simpleToast("resident evil CLICKED $isReady")
            if (isReady) {
                simpleToast("resident evil  UNCLOCKED")
                ResidentEvilMenuActivity.startResidentEvilMenuActivity(this@SelectGameModeActivity)
            }
        }
    }

    private fun simpleToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
