package com.example.projectoeva1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPresentation = findViewById<Button>(R.id.btnPresentation)
        btnPresentation.setOnClickListener {
            val intent = Intent(this, PresentationActivity::class.java)
            startActivity(intent)
        }
    }
}