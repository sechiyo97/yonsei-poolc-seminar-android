package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        submit_button.setOnClickListener{
            goToMainActivity()
        }

        edit_text.requestFocus()
    }
    fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent) // 메인액티비티 실행
        finish() // 스플래시액티비티 종료
    }
}