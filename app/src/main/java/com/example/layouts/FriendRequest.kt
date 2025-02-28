package com.example.layouts

data class FriendRequest(
    val profileImageResId: Int,
    val name: String,
    val rating: Int,
    val isOnline: Boolean = false
)
