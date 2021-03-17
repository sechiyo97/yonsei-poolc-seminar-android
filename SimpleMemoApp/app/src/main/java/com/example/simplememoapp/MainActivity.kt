package com.example.simplememoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

fun RecyclerView.newFun() = println(this)

//dp를 px로 변환 (dp를 입력받아 px을 리턴)
fun Context.dp2px(dp: Float) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)


class MainActivity : AppCompatActivity() {
    var memoList : MutableList<Memo> = mutableListOf()
    var memoAdapter = MemoAdapter(memoList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_memo.newFun()

        recycler_memo.layoutManager = LinearLayoutManager(this)
        recycler_memo.adapter = memoAdapter

        // 새 메모 생성
        button_new_memo.setOnClickListener {
            val editText = EditText(this)

            val dialog = AlertDialog.Builder(this)
                .setTitle("새 메모")
                .setView(editText)
                .setPositiveButton("저장") {_,_ ->
                    memoList.add(Memo(Date(), editText.text.toString()))
                    memoAdapter.notifyDataSetChanged()
                }
                .setNegativeButton("취소", null)

            dialog.show()
        }
        resources.getDimensionPixelSize()
    }
}
interface Animal{
    fun bark() = println("")
}
class Dog: Animal{

}