package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)
        val userName = sharedPreferences.getString("user_name", null)

        Handler(mainLooper).postDelayed(
            {
                if (userName == null) goToNameActivity()
                else goToMainActivity()
            },
            2000)
    }
    fun goToNameActivity(){
        val intent = Intent(this, NameActivity::class.java)
        startActivity(intent) // 이름액티비티 실행
        finish() // 스플래시액티비티 종료
    }
    fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent) // 이름액티비티 실행
        finish() // 스플래시액티비티 종료
    }
}