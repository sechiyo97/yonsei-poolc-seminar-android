package com.example.firstapplication

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // listen for focus change event
        edit_text.setOnFocusChangeListener { _, hasFocus ->
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            if (hasFocus) imm.showSoftInput(edit_text, 0)
            else imm.hideSoftInputFromWindow(edit_text.windowToken, 0)
        }

        // show keyboard by focusing
        edit_text.requestFocus()

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
            edit_text.clearFocus()
        }
    }

    override fun onResume() {
        super.onResume()
        edit_text.requestFocus()
    }
}