package com.example.layouts.layout2

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.FriendRequest
import com.example.layouts.R
import com.example.layouts.layout3.Layout3
import com.google.android.material.bottomsheet.BottomSheetDialog

class Adapter(private var context: Context,private var requests: List<FriendRequest>,private val onItemClick: (FriendRequest) -> Unit): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tv_name1)
        val rating = view.findViewById<TextView>(R.id.tv_rating1)
        val challengeBtn = view.findViewById<TextView>(R.id.clng_btn)
        val chatBtn = view.findViewById<ImageView>(R.id.ChatBtn)
        val profileImage = view.findViewById<ImageView>(R.id.profile_image)
        val profileStatus = view.findViewById<View>(R.id.profile_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.challenge_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return requests.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val request = requests[position]
        holder.profileImage.setImageResource(requests[position].profileImageResId)
        holder.name.text = request.name
        holder.rating.text = "♟️ ${request.rating}"


        if (holder.profileStatus != null) {
            if (request.isOnline) {
                holder.profileStatus.setBackgroundResource(R.drawable.online_circle)
            }
            else{
                holder.profileStatus.visibility = View.GONE
            }
        } else {
            Log.e("RecyclerAdapter", "profileStatus is null for position $position")
        }

        holder.challengeBtn.setOnClickListener {
            showBotttomSheet(holder.itemView.context,requests.get(position))
        }

        holder.chatBtn.setOnClickListener {
          val intent = Intent(context, Layout3::class.java)
            startActivity(this.context,intent,null)
        }
    }


    // Function to update the list dynamically
    fun updateList(newList: List<FriendRequest>) {
        requests = newList
        notifyDataSetChanged() // Refresh RecyclerView
    }

}