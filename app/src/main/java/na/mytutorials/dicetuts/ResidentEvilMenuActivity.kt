package na.mytutorials.dicetuts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ResidentEvilMenuActivity : AppCompatActivity() {

    companion object {
        fun startResidentEvilMenuActivity(context: Context) {
            val intent = Intent(context, ResidentEvilMenuActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident_evil_menu)
    }
}