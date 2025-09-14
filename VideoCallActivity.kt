package com.example.socially
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VideoCallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)

        // Find the TextView for the caller's name
        val tvCallerName = findViewById<TextView>(R.id.tvCallerName)

        // Get the Intent that started this activity
        val intent = intent

        // Retrieve the caller's name passed as an extra
        val callerName = intent.getStringExtra("CALLER_NAME")

        // Set the text of the TextView to the retrieved name, if it exists
        if (callerName != null) {
            tvCallerName.text = callerName
        }
    }
}