package com.example.socially
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class NotificationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        val btnBack = findViewById<ImageView>(R.id.btnBackFromNotifications)
        val tvFollowing = findViewById<TextView>(R.id.tvFollowing)
        val tvYou = findViewById<TextView>(R.id.tvYou)
        val followingContent = findViewById<ScrollView>(R.id.followingContent)
        val contentContainer = findViewById<LinearLayout>(R.id.contentContainer)
        val youContent = layoutInflater.inflate(R.layout.activity_notifications_you, contentContainer, false) as ScrollView
        val youNotificationsLayout = YouNotificationsLayout(youContent, this)
        youContent.visibility = View.GONE
        contentContainer.addView(youContent)
        btnBack.setOnClickListener {
            finish()
        }
        tvFollowing.setOnClickListener {
            tvFollowing.setTypeface(null, android.graphics.Typeface.BOLD)
            tvFollowing.setTextColor(resources.getColor(android.R.color.black))
            tvYou.setTypeface(null, android.graphics.Typeface.NORMAL)
            tvYou.setTextColor(resources.getColor(android.R.color.darker_gray))
            followingContent.visibility = View.VISIBLE
            youContent.visibility = View.GONE
        }
        tvYou.setOnClickListener {
            tvYou.setTypeface(null, android.graphics.Typeface.BOLD)
            tvYou.setTextColor(resources.getColor(android.R.color.black))
            tvFollowing.setTypeface(null, android.graphics.Typeface.NORMAL)
            tvFollowing.setTextColor(resources.getColor(android.R.color.darker_gray))
            followingContent.visibility = View.GONE
            youContent.visibility = View.VISIBLE
        }
    }
}