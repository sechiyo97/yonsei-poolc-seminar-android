package com.example.profilescreenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        recycler_profile.layoutManager = LinearLayoutManager(this)

        val adapter = ProfileAdapter()
        recycler_profile.adapter = adapter

        // set data
        adapter.profileList = listOf(
            Profile(R.drawable.ic_launcher_background, "이세희", "배고파"),
            Profile(R.drawable.ic_launcher_background, "홍길동", "나는 길동이야"),
            Profile(R.drawable.ic_launcher_background, "뀨", "안뇽"),
            Profile(R.drawable.ic_launcher_foreground, "사람", "어떤 사람"),
            Profile(R.drawable.ic_launcher_foreground, "사람", "어떤 사람"),
            Profile(R.drawable.ic_launcher_foreground, "사람", "어떤 사람"),
            Profile(R.drawable.ic_launcher_foreground, "사람", "어떤 사람"),
            Profile(R.drawable.ic_launcher_foreground, "사람", "어떤 사람"),
            Profile(R.drawable.ic_launcher_foreground, "마지막 사람", "마지막 사람"),
        )
        adapter.notifyDataSetChanged()
    }
}