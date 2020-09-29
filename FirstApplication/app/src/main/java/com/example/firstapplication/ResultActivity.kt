package com.example.firstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        submit_datetime.text = intent.getStringExtra("submit_datetime")
        submit_text.text = intent.getStringExtra("submit_text")
    }
}