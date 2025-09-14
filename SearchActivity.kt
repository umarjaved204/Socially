package com.example.socially

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.LinearLayout

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Set up footer navigation
        setupFooterNavigation()

        // Add search bar click functionality
        setupSearchBarClick()
    }

    private fun setupFooterNavigation() {
        val btnHome = findViewById<ImageView>(R.id.btnHome)
        val btnSearch = findViewById<ImageView>(R.id.btnSearch)
        val btnAdd = findViewById<ImageView>(R.id.btnAdd)
        val btnHeart = findViewById<ImageView>(R.id.btnHeart)
        val btnProfile = findViewById<ImageView>(R.id.btnProfile)

        // Home button - go back to main activity
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Search button - already on search screen, do nothing or refresh
        btnSearch.setOnClickListener {
            // Already on search screen - you can add refresh functionality here if needed
        }

        // Add button - you can add functionality later
        btnAdd.setOnClickListener {
            // TODO: Add functionality for Add button
        }

        // Heart button - you can add functionality later
        btnHeart.setOnClickListener {
            // TODO: Add functionality for Notifications
        }

        // Profile button - you can add functionality later
        btnProfile.setOnClickListener {
            // TODO: Add functionality for Profile
        }
    }

    private fun setupSearchBarClick() {
        // Find the search bar container (the LinearLayout with search icon and text)
        val searchContainer = findViewById<LinearLayout>(R.id.searchContainer)

        searchContainer.setOnClickListener {
            val intent = Intent(this, SearchResultsActivity::class.java)
            startActivity(intent)
        }
    }
}