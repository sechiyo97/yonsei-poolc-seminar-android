package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*

class EditNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_name)

        submit_button.setOnClickListener{
            saveUserName()
            goToMainActivity()

            submit_button.animate().rotationBy(360f)
            submit_button.animate().scaleX(0f)
            submit_button.animate().scaleY(0f)
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
        overridePendingTransition(0, R.anim.fade_out)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        goToMainActivity()
    }
}