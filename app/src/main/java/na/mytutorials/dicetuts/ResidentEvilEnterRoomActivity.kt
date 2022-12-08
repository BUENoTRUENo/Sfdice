package na.mytutorials.dicetuts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import na.mytutorials.dicetuts.databinding.ActivityResidentEvilEnterRoomBinding

class ResidentEvilEnterRoomActivity : AppCompatActivity() {

    companion object {
        fun startResidentEvilEnterRoomActivity(context: Context){
            val intent = Intent(context,ResidentEvilEnterRoomActivity::class.java)
            context.startActivity(intent)
        }
    }
    val binding by lazy { ActivityResidentEvilEnterRoomBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}