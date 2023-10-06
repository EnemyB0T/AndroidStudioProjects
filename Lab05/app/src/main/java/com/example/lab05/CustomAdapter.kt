package com.example.lab05

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private val list: List<MyModel>) :
    RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(context).inflate(R.layout.single_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.textName.text = list[position].getName()
        holder.textAge.text = list[position].getAge().toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}