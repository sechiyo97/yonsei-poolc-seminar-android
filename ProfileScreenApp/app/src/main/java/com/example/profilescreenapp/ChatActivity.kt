package com.example.profilescreenapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // 받아온 사용자 이름 보여주기
        val chatInfoText = intent.getStringExtra("user_name") + "님과의 채팅방입니다."
        text_chat_info.text = chatInfoText
    }

}