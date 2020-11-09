package com.example.ddaycountapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // start_date_text를 누르면 datePicker를 켜주세요
        setting_button.setOnClickListener{
            val datePicker = DatePickerDialog(this)

            datePicker.setOnDateSetListener{ _, year, month, day ->
                //println("DATE SET")

                // 0000.00.00을 날짜로 바꾸기
                start_date_text.text = "$year.${month+1}.$day 부터"

                // D+0을 디데이 계산해서 넣어 주기
                calculateAndDisplayDday(year, month, day)
            }

            datePicker.show()
        }
    }

    fun calculateAndDisplayDday(year: Int, month: Int, day: Int){
        // start
        val startDateMillis = Calendar.getInstance().apply{
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, day)
        }.timeInMillis

        // end
        val endDateMillis = System.currentTimeMillis()

        // calculate
        val pastDate =
            ((endDateMillis - startDateMillis) / (24*60*60*1000))
                .toInt()

        d_day_text.text = if (pastDate>=0) "D+${pastDate+1}" else "D${pastDate}"

        // 밀리초 차이 = (오늘의 밀리초) - (시작 날짜의 밀리초)
        // 흐른 날짜 = 밀리초 차이 / (하루에 해당하는 밀리초 수)
    }
}