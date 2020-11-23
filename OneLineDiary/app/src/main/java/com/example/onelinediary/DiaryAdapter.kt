package com.example.onelinediary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DiaryAdapter(var diaryList : List<Diary>) : RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>(){

    inner class DiaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val datetimeText = itemView.findViewById<TextView>(R.id.text_diary_datetime)
        val dataText = itemView.findViewById<TextView>(R.id.text_diary_data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_diary, parent, false)
        return DiaryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        // 데이터 뷰에 적용
        holder.datetimeText.text = diaryList[position].datetime.toString()
        holder.dataText.text = diaryList[position].data

        // 아이템 누르면 수정 화면으로 이동

    }

    override fun getItemCount(): Int {
        return diaryList.size
    }
}