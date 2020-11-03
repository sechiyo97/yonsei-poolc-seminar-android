package com.example.ddaycounter

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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
                calculateAndDisplayResult(year, month, day)
            }

            datePickerDialog.show()
        }
    }

    fun calculateAndDisplayResult(year:Int, month:Int, day:Int){
        // set date text
        val dateString = "$year.${month+1}.$day 부터"
        start_date_text.text = dateString

        // start
        val startDateTime = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, day)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        // end
        val endDateTime = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        // calc
        val pastDate =
            ((endDateTime - startDateTime) / (24 * 60 * 60 * 1000))
                .toInt() + 1

        // update
        d_day_text.text = "D+$pastDate"
    }
}