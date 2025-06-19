package vcmsa.ci.musicapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.content.Intent
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var btnAddToPlaylist: Button
    private lateinit var btnNextScreen: Button
    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.songDetails)
        btnAddToPlaylist = findViewById(R.id.btnAddToPlaylist)
        btnNextScreen = findViewById(R.id.btnNextScreen)
        btnExit = findViewById(R.id.btnExit)

        btnAddToPlaylist.setOnClickListener {
            // Please enter song details
            val songDetails = editText.text.toString()
            if (songDetails.isNotEmpty()) {
                // Pass the song details to the next screen
                val intent = Intent(this, DetailedViewScreen::class.java)
                intent.putExtra("songDetails", songDetails)
                startActivity(intent)
            }
            if (songDetails.isEmpty()) {
                editText.error = "Please enter song details"
            }
        }

        btnNextScreen.setOnClickListener {
            // Go to the next screen
            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            // Exit the app
            finishAffinity()
            exitProcess(0)
        }
    }
}
