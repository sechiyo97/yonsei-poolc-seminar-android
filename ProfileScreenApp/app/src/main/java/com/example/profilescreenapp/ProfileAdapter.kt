package com.example.profilescreenapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    // 데이터 리스트
    var profileList : List<Profile> = listOf()

    inner class ProfileViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageProfile = itemView.findViewById<ImageView>(R.id.image_profile)
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        val textMessage = itemView.findViewById<TextView>(R.id.text_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent,false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.imageProfile.setImageResource(profileList[position].image)
        holder.textName.text = profileList[position].name
        holder.textMessage.text = profileList[position].message

        // 누르면 채팅창 띄우기
        holder.itemView.setOnClickListener{
            val activityContext = holder.itemView.context
            val intent = Intent(activityContext, ChatActivity::class.java)
            activityContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return profileList.size
    }
}