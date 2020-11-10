package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        name_submit_button.setOnClickListener {
            saveNameAndGoToMainActivity()
        }
    }
    fun saveNameAndGoToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)

        //intent.putExtra("user_name", name_edit_text.text.toString())
        // 정보 기기에 저장
        val sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)
        sharedPreferences
            .edit()
            .putString("user_name", name_edit_text.text.toString())
            .apply()

       startActivity(intent) // 메인액티비티 실행
        finish() // 스플래시액티비티 종료
    }
}