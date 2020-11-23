package com.example.galleryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 리사이클러뷰에 어댑터랑 레이아웃 형식 지정해 주기
        val imageAdapter = ImageAdapter()
        recycler_view.adapter = imageAdapter
        recycler_view.layoutManager = GridLayoutManager(this, 3)

        // 데이터셋 만들기
        val imageList = listOf(
            R.drawable.family,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.family,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.family,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.family,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.family,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.family,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.family,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.divorce,
            R.drawable.family
        )
        // 화면에 데이터셋 넣어주기
        imageAdapter.imageResourceList = imageList
        imageAdapter.notifyDataSetChanged()
    }
}