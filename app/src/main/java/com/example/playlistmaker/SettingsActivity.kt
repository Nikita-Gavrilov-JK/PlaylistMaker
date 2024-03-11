package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backBut = findViewById<ImageButton>(R.id.backButton)
        backBut.setOnClickListener {
            val backButIntent = Intent(this, MainActivity::class.java)
            startActivity(backButIntent)
        }
    }
}