package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_post_list.*
import kotlinx.android.synthetic.main.activity_post_list.input_text
import kotlinx.android.synthetic.main.activity_post_list.time_text


class PostListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        new_post_button.setOnClickListener{
            goToMainActivity()
        }
    }
    fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivityForResult(intent, 1000) // 메인액티비티 실행
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            println("OK")
            val time = data?.getStringExtra("time")
            val text = data?.getStringExtra("text")

            time_text.text = time
            input_text.text =text // 입력값값
        }
   }
}