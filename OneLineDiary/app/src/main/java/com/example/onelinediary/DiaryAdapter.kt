package com.example.onelinediary

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.marginEnd
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class DiaryAdapter(var diaryList : MutableList<Diary>) : RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>(){

    inner class DiaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val datetimeText = itemView.findViewById<TextView>(R.id.text_diary_datetime)
        val dataText = itemView.findViewById<TextView>(R.id.text_diary_data)
        val editButton = itemView.findViewById<Button>(R.id.button_diary_edit)
        val deleteButton = itemView.findViewById<Button>(R.id.button_diary_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_diary, parent, false)
        return DiaryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        // 데이터 뷰에 적용
        val dateTimeText = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault())
            .format(diaryList[position].datetime)
        holder.datetimeText.text = dateTimeText
        holder.dataText.text = diaryList[position].data

        // 아이템 제거
        holder.deleteButton.setOnClickListener {
            diaryList.removeAt(position)
            notifyDataSetChanged()
            println("position $position size $itemCount")
        }

        // 수정 버튼
        holder.editButton.setOnClickListener {
            val editText = EditText(holder.itemView.context)
            editText.setText(diaryList[position].data)

            val dialog = AlertDialog.Builder(holder.itemView.context)
                .setTitle("메모 수정")
                .setView(editText)
                .setPositiveButton("저장") { _, _ ->
                    diaryList[position].data = editText.text.toString()
                    notifyDataSetChanged()
                }
                .setNegativeButton("취소", null)

            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return diaryList.size
    }
}