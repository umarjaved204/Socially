package com.example.socially
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val btnCancel = findViewById<TextView>(R.id.btnCancel)
        val btnDone = findViewById<TextView>(R.id.btnDone)
        btnCancel.setOnClickListener {
            finish()
        }
        btnDone.setOnClickListener {
            // Here you would save the data to a database or shared preferences
            // For now, we'll just close the activity
            finish()
        }
    }
}