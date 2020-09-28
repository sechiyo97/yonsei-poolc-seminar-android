package com.example.firstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add on click event
        submit_button.setOnClickListener{
            // show toast on click
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()

            // show submit data
            submit_datetime.text = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).format(
                Date()
            )
            submit_text.text = edit_text.text.toString()

            // after submit
            edit_text.text.clear() // clear
        }
    }
}