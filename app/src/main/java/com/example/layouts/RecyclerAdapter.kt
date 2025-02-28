package com.example.layouts

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val requests: List<FriendRequest>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tv_name)
        val rating = view.findViewById<TextView>(R.id.tv_rating)
        val accept = view.findViewById<Button>(R.id.accept)
        val decline = view.findViewById<Button>(R.id.decline)
        val profileImage = view.findViewById<ImageView>(R.id.profile_image)
        val profileStatus = view.findViewById<View>(R.id.profile_status2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.friend_request_item, parent, false)
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
            } else {
                holder.profileStatus.visibility = View.GONE
            }
        } else {
            Log.e("RecyclerAdapter", "profileStatus is null for position $position")
        }

        holder.accept.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Accepted ${request.name}", Toast.LENGTH_SHORT).show()
        }

        holder.decline.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Declined ${request.name}", Toast.LENGTH_SHORT).show()
        }
    }

    }
