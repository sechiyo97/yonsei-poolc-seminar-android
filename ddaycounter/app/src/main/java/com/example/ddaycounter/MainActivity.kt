package com.example.ddaycounter

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initOnClickListener()
    }

    fun initOnClickListener(){
        // show date picker on click setting icon
        setting_button.setOnClickListener{

            val datePickerDialog = DatePickerDialog(this)

            datePickerDialog.setOnDateSetListener{
                _, year, month, day ->
                val dateString = "$year.$month.$day 부"
                start_date_text.text = dateString

                calculateAndDisplayResult(year, month, day)
            }

            datePickerDialog.show()
        }
    }

    fun calculateAndDisplayResult(year:Int, month:Int, day:Int){

    }
}