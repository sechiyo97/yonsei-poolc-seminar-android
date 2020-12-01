package com.example.chatscreenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val profileList : MutableList<Profile> = mutableListOf()
    init{
        for (i in 0 until 1000) {
            profileList.add(Profile(R.drawable.ic_launcher_foreground, "이름$i", "메시지$i"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_profile.layoutManager = LinearLayoutManager(this)
        recycler_profile.adapter = ProfileAdapter(profileList)
    }
}