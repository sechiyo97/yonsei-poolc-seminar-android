package com.example.galleryexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = GridLayoutManager(this, 3)

        val myAdapter = MyImageAdapter()
        recycler_view.adapter = myAdapter

        val imageDataList = mutableListOf<ImageData>()
        val singleList = mutableListOf(
            ImageData(
                "name string",
                "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fb2Bg9o%2FbtqGbp6dO0Y%2Fo3BiklhEITjXEYP5dwTvm1%2Fimg.png"),
        )
        for (i in 0..100) imageDataList.addAll(singleList)

        myAdapter.imageDataList = imageDataList
        //myAdapter.notifyDataSetChanged()


    }
}