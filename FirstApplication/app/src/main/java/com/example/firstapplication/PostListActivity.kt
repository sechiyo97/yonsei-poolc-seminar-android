package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_post_list.*

class PostListActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        setPostData() // 저장된 데이터 불러오기

        new_post_button.setOnClickListener {
            goToMainActivity()
        }
    }

    fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivityForResult(intent, 1000) // 이름액티비티 실행
    }

    // 상위 액티비티가 꺼졌을 때 실행하는 코드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1000 && resultCode == RESULT_OK){
            setPostData()
        }
    }

    // 저장된 데이터 불러오기
    fun setPostData(){
        val sharedPreferences = getSharedPreferences("post_info", MODE_PRIVATE)
        time_text.text = sharedPreferences.getString("post_time", "없음")
        input_text.text = sharedPreferences.getString("post_input", "없음")
    }
}
