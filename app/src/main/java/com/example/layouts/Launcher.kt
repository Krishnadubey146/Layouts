package com.example.layouts

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layouts.layout2.FriendChallenge
import com.example.layouts.layout3.Layout3
import com.google.android.material.button.MaterialButton

class Launcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_launcher)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<MaterialButton>(R.id.button)
        val button1 = findViewById<MaterialButton>(R.id.button1)
        val button3 = findViewById<MaterialButton>(R.id.btn3)

        button.setOnClickListener {
            startActivity(Intent(this, FriendChallenge::class.java))
        }

        button1.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        button3.setOnClickListener{
            startActivity(Intent(this,Layout3::class.java))
        }





    }
}