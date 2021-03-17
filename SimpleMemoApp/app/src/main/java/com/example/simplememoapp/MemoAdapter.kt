package com.example.simplememoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MemoAdapter(var memoList: MutableList<Memo>) : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>(){

    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var timestampText: TextView = itemView.findViewById(R.id.text_memo_timestamp)
        var contentText: TextView = itemView.findViewById(R.id.text_memo_content)
        var editButton: Button = itemView.findViewById(R.id.button_memo_edit)
        var deleteButton: Button = itemView.findViewById(R.id.button_memo_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        // 뷰에 데이터를 보여준다.
        val timestampString = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault())
            .format(memoList[position].timeStamp)
        holder.timestampText.text = timestampString
        holder.contentText.text = memoList[position].content

        // 데이터 삭제
        holder.deleteButton.setOnClickListener {
            memoList.removeAt(position)
            notifyDataSetChanged()
        }

        // 데이터 수정
        holder.editButton.setOnClickListener {
            val editText = EditText(holder.itemView.context)
            editText.setText(memoList[position].content)

            val dialog = AlertDialog.Builder(holder.itemView.context)
                .setTitle("메모 수정하기")
                .setView(editText)
                .setPositiveButton("저장") {_,_ ->
                    memoList[position].apply{
                        content = editText.text.toString()
                        timeStamp = Date()
                    }
                    notifyDataSetChanged()
                }
                .setNegativeButton("취소", null)

            dialog.show()
        }
    }

    override fun getItemCount() = memoList.size

}