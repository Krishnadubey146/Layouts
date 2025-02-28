package com.example.layouts

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.layout2.FriendChallenge
import com.example.layouts.layout3.Layout3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val imgBack: ImageView = findViewById<ImageView>(R.id.imgBack2)
        imgBack.setOnClickListener {
            startActivity(Intent(this, FriendChallenge::class.java))
        }

        val friendRequests = listOf(
            FriendRequest(R.drawable.shoaib,"Krishna Dubey", 1000,true),
            FriendRequest(R.drawable.vk,"Shoaib Akhtar", 200,false),
            FriendRequest(R.drawable.img_2,"Rushikesh Dumbare", 600,true),
            FriendRequest(R.drawable.img_3,"Sohail Ali", 500,false),
            FriendRequest(R.drawable.img_4,"Sunil Mohite", 500,false),
            FriendRequest(R.drawable.img_5,"Rohan Sonatakke", 2200,true),
            FriendRequest(R.drawable.img_6,"Prem Dubey", 1000,true),
            FriendRequest(R.drawable.img_6,"virat sharma", 1840,true),
            FriendRequest(R.drawable.img_3,"Rohit Sharma", 1080,false),
            FriendRequest(R.drawable.img_4,"SIkhar Dhawan", 400,false),
            FriendRequest(R.drawable.img_2,"Sikhar Dhawan", 400,false),
            FriendRequest(R.drawable.vk,"Sikhar Dhawan", 400,true),
            FriendRequest(R.drawable.img_3,"Sikhar Dhawan", 400,true),
            FriendRequest(R.drawable.img_2,"Swapnil Sonatakke", 400,false),
            FriendRequest(R.drawable.img_1,"Sikhar Dhawan", 400,true),
            FriendRequest(R.drawable.img_5,"Sikhar Dhawan", 400,false),
            FriendRequest(R.drawable.img_2,"Sikhar Dhawan", 400,true),
            FriendRequest(R.drawable.img_2,"Sikhar Dhawan", 400,true),
            )

        recyclerView.adapter = RecyclerAdapter(friendRequests)
    }
}