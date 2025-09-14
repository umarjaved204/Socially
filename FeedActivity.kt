package com.example.socially
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.content.Intent
class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        val btnHome = findViewById<ImageView>(R.id.btnHome)
        val btnSearch = findViewById<ImageView>(R.id.btnSearch)
        val btnAdd = findViewById<ImageView>(R.id.btnAdd)
        val btnHeart = findViewById<ImageView>(R.id.btnHeart)
        val btnProfile = findViewById<ImageView>(R.id.btnProfile)
        val btnMessages = findViewById<ImageView>(R.id.btnMessages)
        val btnstory = findViewById<ImageView>(R.id.story1)
        val btnstory1 = findViewById<ImageView>(R.id.story2)
        btnstory1.setOnClickListener {
            val intent = Intent(this, StoryViewerActivity::class.java)
            startActivity(intent)

        }
        btnstory.setOnClickListener {
            val intent = Intent(this, StoryViewerActivity::class.java)
            startActivity(intent)

        }

        btnHome.setOnClickListener {
            // Already on home screen - you can add refresh functionality here if needed
        }
        btnSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        btnAdd.setOnClickListener {
            val intent = Intent(this, AddPostActivity::class.java)
            startActivity(intent)
            // TODO: Add functionality for Add button
        }
        // Heart button - navigate to notifications activity
        btnHeart.setOnClickListener {
            val intent = Intent(this, NotificationsActivity::class.java)
            startActivity(intent)
        }
        btnProfile.setOnClickListener {
            // TODO: Add functionality for Profile
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        // Messages button - navigate to messages activity
        btnMessages.setOnClickListener {
            val intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
        }
    }
}