package com.example.layouts.layout3

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.FriendRequest
import com.example.layouts.R
import com.example.layouts.layout2.Adapter

class LayoutAdapter(private var requests: List<FriendRequest>): RecyclerView.Adapter<LayoutAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tv_name2)
        val profileImage = view.findViewById<ImageView>(R.id.profile_image)
        val profileStatus = view.findViewById<View>(R.id.profile_status1)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val request = requests[position]
        holder.profileImage.setImageResource(requests[position].profileImageResId)
        holder.name.text = request.name

        if (holder.profileStatus != null) {
            if (request.isOnline) {
                holder.profileStatus.setBackgroundResource(R.drawable.online_circle)
            } else {
                holder.profileStatus.visibility = View.GONE
            }
        } else {
            Log.e("RecyclerAdapter", "profileStatus is null for position $position")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return requests.size

    }

    fun updateList(newlist: List<FriendRequest>) {
        requests = newlist
        notifyDataSetChanged()

    }

}