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

        val imageDataList = listOf(
            ImageData(R.drawable.img_001, "001"),
            ImageData(R.drawable.img_002, "002"),
            ImageData(R.drawable.img_003, "003"),
            ImageData(R.drawable.img_004, "004"),
            ImageData(R.drawable.img_005, "005")
        )

        myAdapter.imageDataList = imageDataList
        //myAdapter.notifyDataSetChanged()


    }
}