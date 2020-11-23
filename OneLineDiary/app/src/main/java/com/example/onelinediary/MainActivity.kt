package com.example.onelinediary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var diaryList : MutableList<Diary> = mutableListOf()
    val adapter = DiaryAdapter(diaryList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_diary.layoutManager = LinearLayoutManager(this)
        recycler_diary.adapter = adapter

        button_new_diary.setOnClickListener {
            val newDiary = Diary(Date(), "새 메모")
            adapter.diaryList.add(0, newDiary)
            adapter.notifyDataSetChanged()
        }
    }
}