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
            goToMainActivity()
        }

        edit_text.requestFocus()
    }
    fun saveUserName(){
        val userName = getSharedPreferences("userInfo", MODE_PRIVATE)
        userName.edit().putString("user_name", edit_text.text.toString()).apply()
    }
    fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        //intent.putExtra("user_name", edit_text.text.toString())
        startActivity(intent) // 메인액티비티 실행
        finish() // 스플래시액티비티 종료
    }
}