package com.example.socially
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.ImageView
import android.text.TextWatcher
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity

class SearchResultsActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var clearButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        // Initialize views
        searchEditText = findViewById(R.id.searchEditText)
        clearButton = findViewById(R.id.clearButton)

        // Set up search functionality
        setupSearchFunctionality()

        // Focus on search field and show keyboard
        searchEditText.requestFocus()
    }

    private fun setupSearchFunctionality() {
        // Clear button functionality
        clearButton.setOnClickListener {
            searchEditText.text.clear()
        }

        // Back button functionality
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish() // Go back to previous screen
        }

        // Text change listener for search
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for this implementation
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // You can add real-time search functionality here
                // For now, we'll just show/hide clear button
                if (s?.length ?: 0 > 0) {
                    clearButton.visibility = TextView.VISIBLE
                } else {
                    clearButton.visibility = TextView.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // You can add search result filtering here
            }
        })

        // Set up tab click listeners
        setupTabNavigation()
    }

    private fun setupTabNavigation() {
        val topTab = findViewById<TextView>(R.id.topTab)
        val accountsTab = findViewById<TextView>(R.id.accountsTab)
        val tagsTab = findViewById<TextView>(R.id.tagsTab)
        val placesTab = findViewById<TextView>(R.id.placesTab)

        // Top tab (default selected)
        topTab.setOnClickListener {
            selectTab(topTab, accountsTab, tagsTab, placesTab)
        }

        // Accounts tab
        accountsTab.setOnClickListener {
            selectTab(accountsTab, topTab, tagsTab, placesTab)
        }

        // Tags tab
        tagsTab.setOnClickListener {
            selectTab(tagsTab, topTab, accountsTab, placesTab)
        }

        // Places tab
        placesTab.setOnClickListener {
            selectTab(placesTab, topTab, accountsTab, tagsTab)
        }
    }

    private fun selectTab(selectedTab: TextView, vararg otherTabs: TextView) {
        // Set selected tab appearance
        selectedTab.setTextColor(resources.getColor(android.R.color.black))

        // Set unselected tabs appearance
        for (tab in otherTabs) {
            tab.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        // Here you can add logic to show different content based on selected tab
    }
}