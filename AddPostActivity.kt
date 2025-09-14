package com.example.socially
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class AddPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
        val btnCancel = findViewById<TextView>(R.id.btnCancel)
        val btnNext = findViewById<TextView>(R.id.btnNext)
        btnCancel.setOnClickListener {
            finish()
        }
        btnNext.setOnClickListener {
            // Here you would navigate to the next screen to add a caption
        }
    }
}