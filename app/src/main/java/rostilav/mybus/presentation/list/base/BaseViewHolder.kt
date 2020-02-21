package com.example.easyreader3.presentation.adapters.base

import android.support.v7.widget.RecyclerView
import android.view.View


abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(model: T)
}