package com.example.socially
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class MessagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        // Find the back button and set a click listener to go back
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // This closes the current activity and returns to the previous one
        }

        // Find the LinearLayout for the 'joshua_l' chat row
        val joshuaChatRow = findViewById<LinearLayout>(R.id.chatRowJoshua) // Add this ID to your XML

        // Set a click listener on the chat row
        joshuaChatRow.setOnClickListener {
            // Create an explicit Intent to go to ChatActivity
            val intent = Intent(this, ChatActivity::class.java)

            // Pass the user's name as an extra
            intent.putExtra("CHAT_USER_NAME", "joshua_l")

            // Start the new activity
            startActivity(intent)
        }
    }
}