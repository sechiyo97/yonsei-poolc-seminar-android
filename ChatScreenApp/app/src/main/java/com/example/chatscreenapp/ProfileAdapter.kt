package com.example.chatscreenapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(
    var profileList : MutableList<Profile>
) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImageView: ImageView = itemView.findViewById(R.id.image_profile)
        val nameTextView: TextView = itemView.findViewById(R.id.text_name)
        val messageTextView: TextView = itemView.findViewById(R.id.text_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profileList[position]

        holder.profileImageView.setImageResource(profile.profileImage)
        holder.nameTextView.text = profile.name
        holder.messageTextView.text = profile.message


        // 해당 아이템뷰를 누르면 그 사람과의 채팅방으로 이동
        holder.itemView.setOnClickListener {
            val activityContext = holder.itemView.context
            val intent = Intent(activityContext, ChatActivity::class.java)
            intent.putExtra("user_name", profile.name)
            activityContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return profileList.size

    }
}