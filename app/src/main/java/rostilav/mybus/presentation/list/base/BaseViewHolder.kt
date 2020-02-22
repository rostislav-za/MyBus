package com.example.easyreader3.presentation.adapters.base

import androidx.recyclerview.widget.RecyclerView
import android.view.View


abstract class BaseViewHolder<T>(itemView: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
    abstract fun bind(model: T)
}