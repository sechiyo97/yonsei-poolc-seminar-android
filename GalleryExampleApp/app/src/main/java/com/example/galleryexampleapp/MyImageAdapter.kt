package com.example.galleryexampleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MyImageAdapter : RecyclerView.Adapter<MyImageAdapter.MyViewHolder>(){
    var imageResourceList : List<Int> = emptyList()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  MyViewHolder {
        // create a new view
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.setImageResource(imageResourceList[position])
    }

    override fun getItemCount(): Int {
        return imageResourceList.size
    }

}