package com.example.socially

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class StoryViewerActivity : AppCompatActivity() {

    private lateinit var storyImage: ImageView
    private lateinit var closeButton: ImageView
    private lateinit var usernameText: TextView
    private lateinit var timeText: TextView
    private lateinit var progressBar: View
    private lateinit var bottomControlsContainer: View

    private val handler = Handler(Looper.getMainLooper())
    private var storyDuration = 5000L // 5 seconds per story

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_viewer)

        // Initialize views
        initializeViews()

        // Get story data from intent
        val username = intent.getStringExtra("username") ?: "Your Story"
        val timeAgo = intent.getStringExtra("time") ?: "2h"

        // Set story data
        setupStoryData(username, timeAgo)

        // Start story timer
        startStoryTimer()

        // Setup click listeners
        setupClickListeners()

        // Hide system bars for immersive experience
        hideSystemBars()
    }

    private fun initializeViews() {
        storyImage = findViewById(R.id.storyImage)
        closeButton = findViewById(R.id.closeButton)
        usernameText = findViewById(R.id.usernameText)
        timeText = findViewById(R.id.timeText)
        progressBar = findViewById(R.id.progressBar)
        bottomControlsContainer = findViewById(R.id.bottomControlsContainer)
    }

    private fun setupStoryData(username: String, timeAgo: String) {
        usernameText.text = username
        timeText.text = timeAgo

        // Set the story image (you can pass different images via intent)
        storyImage.setImageResource(R.drawable.story_image)
    }

    private fun startStoryTimer() {
        // Animate progress bar
        progressBar.animate()
            .scaleX(1f)
            .setDuration(storyDuration)
            .start()

        // Auto close after story duration
        handler.postDelayed({
            finish()
        }, storyDuration)
    }

    private fun setupClickListeners() {
        // Close button
        closeButton.setOnClickListener {
            finish()
        }

        // Tap right side to go to next story (for now just close)
        val rightTapArea = findViewById<View>(R.id.rightTapArea)
        rightTapArea.setOnClickListener {
            finish() // In a real app, you'd load the next story
        }

        // Tap left side to go to previous story (for now just close)
        val leftTapArea = findViewById<View>(R.id.leftTapArea)
        leftTapArea.setOnClickListener {
            finish() // In a real app, you'd load the previous story
        }

        // Long press to pause (optional feature)
        storyImage.setOnLongClickListener {
            // Pause functionality can be added here
            true
        }
    }

    private fun hideSystemBars() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}