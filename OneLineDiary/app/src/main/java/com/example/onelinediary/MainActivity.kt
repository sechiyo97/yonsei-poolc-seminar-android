package com.example.onelinediary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var diaryList : MutableList<Diary> = mutableListOf(
        Diary(Date(), "new1"),
        Diary(Date(), "new2"),
        Diary(Date(), "new3"),
        Diary(Date(), "new4")
    )
    val adapter = DiaryAdapter(diaryList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_diary.layoutManager = LinearLayoutManager(this)
        recycler_diary.adapter = adapter

        button_new_diary.setOnClickListener {
            val newDiary = Diary(Date(), "새로운 한줄 메모입니다.")
            adapter.diaryList.add(0, newDiary)
            adapter.notifyDataSetChanged()
        }
    }
}