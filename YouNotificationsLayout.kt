package com.example.socially
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.Toast
class YouNotificationsLayout(private val rootView: View, private val activity: Activity) {
    init {
        val btnFollow = rootView.findViewById<Button>(R.id.btnFollow)
        btnFollow.setOnClickListener {
            Toast.makeText(activity, "Following user!", Toast.LENGTH_SHORT).show()
        }
        val btnMessage = rootView.findViewById<Button>(R.id.btnMessage)
        btnMessage.setOnClickListener {
            val intent = Intent(activity, ChatActivity::class.java)
            intent.putExtra("CHAT_USER_NAME", "martini_rond")
            activity.startActivity(intent)
        }
    }
}