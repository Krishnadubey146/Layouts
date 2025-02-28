package com.example.layouts.layout3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.FriendRequest
import com.example.layouts.R
import com.example.layouts.layout2.FriendChallenge

class Layout3 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter1: LayoutAdapter
    private lateinit var search_bar: EditText
    private var friendList = mutableListOf<FriendRequest>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_layout3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgBack: ImageView = findViewById<ImageView>(R.id.imageButton)

        imgBack.setOnClickListener {
            startActivity(Intent(this, FriendChallenge::class.java))
        }

        recyclerView = findViewById(R.id.recyclerView2)
        search_bar = findViewById(R.id.searchBar)


        friendList = mutableListOf(
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

        adapter1 = LayoutAdapter(friendList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter1


        search_bar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())  // Call filter function
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun filter(query: String) {
        val filteredList = friendList.filter {
            it.name.contains(query, ignoreCase = true)
        }
        adapter1.updateList(filteredList)
    }
}