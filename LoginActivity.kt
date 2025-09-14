package com.example.socially

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLoginNow = findViewById<Button>(R.id.btnLoginNow)
        val tvSignupLink = findViewById<TextView>(R.id.tvSignupLink)

        btnLoginNow.setOnClickListener {
            // Later you can add login validation here
        }
        val intent = Intent(this, FeedActivity::class.java)
        startActivity(intent)

        tvSignupLink.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
