package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add on click event
        submit_button.setOnClickListener{

            // show toast
            if (edit_text.text.isBlank()) {
                Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
                showResultActivity()
            }

            /*
            // show submit data
            submit_datetime.text = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).format(Date())
            submit_text.text = edit_text.text.toString()

            // clear edit text after submit
            edit_text.text.clear()

            // hide keyboard
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(edit_text.windowToken, 0)
             */
        }
    }

    fun showResultActivity(){
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("submit_datetime", SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).format(Date()))
        intent.putExtra("submit_text", edit_text.text.toString())
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        edit_text.requestFocus()
    }
}