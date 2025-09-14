package com.example.socially
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val btnBack = findViewById<ImageView>(R.id.btnBackFromChat)
        btnBack.setOnClickListener {
            finish()
        }

        val btnVideoCall = findViewById<ImageView>(R.id.btnVideoCall)
        val tvChatUserName = findViewById<TextView>(R.id.tvChatUserName)

        val userName = intent.getStringExtra("CHAT_USER_NAME")
        if (userName != null) {
            tvChatUserName.text = userName
        }

        // Add a click listener for the video call button
        btnVideoCall.setOnClickListener {
            val intent = Intent(this, VideoCallActivity::class.java)
            // You can pass the user name to the video call screen
            intent.putExtra("CALLER_NAME", tvChatUserName.text.toString())
            startActivity(intent)
        }
    }
}