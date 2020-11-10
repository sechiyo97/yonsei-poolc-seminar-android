package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE)
        val userName = sharedPreferences.getString("user_name", null)
        Handler(mainLooper).postDelayed({
            if (userName == null) goToRegisterActivity()
            else goToPostListActivity()
        }, 2000)
    }
    fun goToRegisterActivity(){
        val intent = Intent(this, EditNameActivity::class.java)
        startActivity(intent) // 메인액티비티 실행
        finish() // 스플래시액티비티 종료
    }
    fun goToPostListActivity(){
        val intent = Intent(this, PostListActivity::class.java)
        startActivity(intent) // 메인액티비티 실행
        finish() // 스플래시액티비티 종료
    }
}