package com.example.lab05

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @JvmField
    var textName: TextView
    @JvmField
    var textAge: TextView

    init {
        textName = itemView.findViewById(R.id.textName)
        textAge = itemView.findViewById(R.id.textAge)
    }
}