package com.example.layouts.layout2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.FriendRequest
import com.example.layouts.MainActivity
import com.example.layouts.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class FriendChallenge : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var searchBar: EditText
    private var friendList = mutableListOf<FriendRequest>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.challenge_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val moreButton: ImageButton = findViewById(R.id.more_button)
        moreButton.setOnClickListener {
            showPopupMenu(it)
        }


        // Initialize UI elements
        recyclerView = findViewById(R.id.recyclerView1)
        searchBar = findViewById(R.id.search_bar)

        // Sample friend list
        friendList = mutableListOf(
            FriendRequest(R.drawable.shoaib, "Krishna Dubey", 1000, true),
            FriendRequest(R.drawable.vk, "Shoaib Akhtar", 200, false),
            FriendRequest(R.drawable.img_2, "Rushikesh Dumbare", 600, true),
            FriendRequest(R.drawable.img_3, "Sohail Ali", 500, false),
            FriendRequest(R.drawable.img_4, "Sunil Mohite", 500, false),
            FriendRequest(R.drawable.img_5, "Rohan Sonatakke", 2200, true),
            FriendRequest(R.drawable.img_6, "Prem Dubey", 1000, true),
            FriendRequest(R.drawable.img_6, "virat sharma", 1840, true),
            FriendRequest(R.drawable.img_3, "Rohit Sharma", 1080, false),
            FriendRequest(R.drawable.img_4, "SIkhar Dhawan", 400, false),
            FriendRequest(R.drawable.img_2, "Sikhar Dhawan", 400, false),
            FriendRequest(R.drawable.vk, "Sikhar Dhawan", 400, true),
            FriendRequest(R.drawable.img_3, "Sikhar Dhawan", 400, true),
            FriendRequest(R.drawable.img_2, "Swapnil Sonatakke", 400, false),
            FriendRequest(R.drawable.img_1, "Sikhar Dhawan", 400, true),
            FriendRequest(R.drawable.img_5, "Sikhar Dhawan", 400, false),
            FriendRequest(R.drawable.img_2, "Sikhar Dhawan", 400, true),
            FriendRequest(R.drawable.img_2, "Sikhar Dhawan", 400, true),
        )

        // Initialize adapter
        adapter = Adapter(this, friendList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Add search bar functionality
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())  // Call filter function
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        val imgBack: ImageButton = findViewById(R.id.imgbtn)
        val linear: LinearLayout = findViewById(R.id.linear)


        imgBack.setOnClickListener {
            finish()
        }

        linear.setOnClickListener()
        {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun showBotttomSheet(context : Context, item : FriendRequest) {
        val bottomSheet = BottomSheetDialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet, null)
        bottomSheet.setContentView(view)

        bottomSheet.setCancelable(true)
        val buttonExit = view.findViewById<ImageView>(R.id.exit)

        val titleTextView = view.findViewById<TextView>(R.id.title)
        val descriptionTextView = view.findViewById<TextView>(R.id.num)

        // Set the data dynamically
        titleTextView.text = item.name
        descriptionTextView.text = item.rating.toString()

        buttonExit.setOnClickListener {
            bottomSheet.dismiss()
        }

        bottomSheet.show()

    }

    // Filter function for searching friends
    private fun filter(query: String) {
        val filteredList = friendList.filter {
            it.name.contains(query, ignoreCase = true)
        }
        adapter.updateList(filteredList)
    }


    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu_more, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_option1 -> {
                    Toast.makeText(this, "Option 1 Selected", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_option2 -> {
                    Toast.makeText(this, "Option 2 Selected", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_option3 -> {
                    Toast.makeText(this, "Option 3 Selected", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        popupMenu.show()
    }
}