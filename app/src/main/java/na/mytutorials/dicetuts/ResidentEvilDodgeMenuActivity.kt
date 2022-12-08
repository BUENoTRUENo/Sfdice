package na.mytutorials.dicetuts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import na.mytutorials.dicetuts.databinding.ActivityResidentEvilDodgeMenuBinding

class ResidentEvilDodgeMenuActivity : AppCompatActivity() {

    companion object {
        fun startResidentEvilDodgeMenuActivity(context: Context) {
            val intent = Intent(context,ResidentEvilDodgeMenuActivity::class.java)
            context.startActivity(intent)
        }
    }

    val binding by lazy { ActivityResidentEvilDodgeMenuBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}