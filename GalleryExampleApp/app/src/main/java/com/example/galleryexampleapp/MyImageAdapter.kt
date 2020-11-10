package com.example.galleryexampleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

data class ImageData(val name: String, val resource : String)

class MyImageAdapter : RecyclerView.Adapter<MyImageAdapter.MyViewHolder>(){
    var imageDataList : List<ImageData> = emptyList()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.image_view)
        val textView = view.findViewById<TextView>(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  MyViewHolder {
        // create a new view
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.imageView.context)
            .load(imageDataList[position].resource)
            .into(holder.imageView)
        holder.textView.text = imageDataList[position].name
    }

    override fun getItemCount(): Int {
        return imageDataList.size
    }

}