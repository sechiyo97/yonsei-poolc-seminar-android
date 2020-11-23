package com.example.onelinediary

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MemoAdapter(var memoList : MutableList<Memo>) : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>(){

    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val datetimeText = itemView.findViewById<TextView>(R.id.text_memo_datetime)
        val dataText = itemView.findViewById<TextView>(R.id.text_memo_data)
        val editButton = itemView.findViewById<Button>(R.id.button_memo_edit)
        val deleteButton = itemView.findViewById<Button>(R.id.button_memo_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        // 데이터 뷰에 적용
        val dateTimeText = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault())
            .format(memoList[position].datetime)
        holder.datetimeText.text = dateTimeText
        holder.dataText.text = memoList[position].data

        // 아이템 제거
        holder.deleteButton.setOnClickListener {
            memoList.removeAt(position)
            notifyDataSetChanged()
            println("position $position size $itemCount")
        }

        // 수정 버튼
        holder.editButton.setOnClickListener {
            val editText = EditText(holder.itemView.context)
            editText.setText(memoList[position].data)

            val dialog = AlertDialog.Builder(holder.itemView.context)
                .setTitle("메모 수정")
                .setView(editText)
                .setPositiveButton("저장") { _, _ ->
                    memoList[position].data = editText.text.toString()
                    notifyDataSetChanged()
                }
                .setNegativeButton("취소", null)

            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return memoList.size
    }
}