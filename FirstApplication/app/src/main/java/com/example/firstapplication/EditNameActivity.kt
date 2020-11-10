package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class EditNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_name_register)

        submit_button.setOnClickListener{
            saveUserName()
            goToNextActivity()
        }

        edit_text.requestFocus()
    }
    fun saveUserName(){
        val userName = getSharedPreferences("userInfo", MODE_PRIVATE)
        userName.edit().putString("user_name", edit_text.text.toString()).apply()
    }
    fun goToNextActivity(){
        val intent = Intent(this, PostListActivity::class.java)
        //intent.putExtra("user_name", edit_text.text.toString())
        startActivity(intent) // 액티비티 실행
    }
}