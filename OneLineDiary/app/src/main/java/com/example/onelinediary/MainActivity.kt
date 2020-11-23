package com.example.onelinediary

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var memoList : MutableList<Memo> = mutableListOf()
    val adapter = MemoAdapter(memoList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_memo.layoutManager = LinearLayoutManager(this)
        recycler_memo.adapter = adapter

        // 새 메모 입력
        button_new_memo.setOnClickListener {
            val editText = EditText(this)

            val dialog = AlertDialog.Builder(this)
                .setTitle("새 메모")
                .setView(editText)
                .setPositiveButton("저장") { _, _ ->
                    val newMemo = Memo(Date(), editText.text.toString())
                    adapter.memoList.add(0, newMemo)
                    adapter.notifyDataSetChanged()
                }
                .setNegativeButton("취소", null)

            dialog.show()
        }
    }
}