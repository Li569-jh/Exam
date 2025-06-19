package vcmsa.ci.musicapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import android.widget.Toast

class DetailedViewScreen : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var btnDisplay: Button
    private lateinit var btnAverageRating: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        textView = findViewById(R.id.textView2)
        btnDisplay = findViewById(R.id.btnDisplay)
        btnAverageRating = findViewById(R.id.btnAverageRating)
        btnBack = findViewById(R.id.btnBack)

        val receivedText = intent
            .getStringExtra("songDetails")

        // This code was adapted from W3Schools
        // W3Schools
        // W3Schools.com
        // https://www.w3schools.com/
        val songTitle = arrayOf(
            "Ocean Eyes",
            "Rain",
            "Cold",
            "Positions",
        )
        // This code was adapted from W3Schools
        // W3Schools
        // W3Schools.com
        // https://www.w3schools.com/
        val songArtist = arrayOf(
            "Billie Eilish",
            "Taylor Swift",
            "Maroon 5",
            "Ariana Grande",
        )
        // This code was adapted from W3Schools
        // W3Schools
        // W3Schools.com
        // https://www.w3schools.com/
        val intRatings = arrayOf(
            3,
            1,
            2,
            4,
        )
        // This code was adapted from W3Schools
        // W3Schools
        // W3Schools.com
        // https://www.w3schools.com/
        val userComments = arrayOf(
            "Heartfelt",
            "Good Love Song",
            "Soul calming",
            "Dancing Song",
        )

        if (receivedText != null) {
            textView.text = "Details from Main Activity: \n$receivedText"
        } else {
            textView.text = "No details were provided."
            // Optionally, show a Toast or handle the case where no text was passed
            Toast.makeText(this, "No text received from MainActivity", Toast.LENGTH_SHORT).show()
        }

        btnDisplay.setOnClickListener {
            if (songTitle.size == songArtist.size && songArtist.size == intRatings.size && intRatings.size == userComments.size) {
                val stringBuilder = StringBuilder()


                for (i in songTitle.indices) {
                    stringBuilder.append("Song Title: ${songTitle[i]}")
                    stringBuilder.append("Artist: ${songArtist[i]}")
                    stringBuilder.append("Rating: ${intRatings[i]}")
                    stringBuilder.append("Comments: ${userComments[i]}")
                }
            }
        }

        btnAverageRating.setOnClickListener {
            // Calculate and display the average rating
            if (intRatings.isNotEmpty()){
                var total = 0.0
                for (rating in intRatings) {
                    total += rating
                }
                val average = total / intRatings.size
                textView.text = "Average Rating: $average"
            } else {
                textView.text = "No ratings available."
            }
        }

        btnBack.setOnClickListener {
            // Go back to the main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}