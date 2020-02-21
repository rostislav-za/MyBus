package com.example.easyreader3.presentation.adapters.base


import android.support.v7.widget.RecyclerView
import java.util.*

abstract class BaseAdapter<P> : RecyclerView.Adapter<BaseViewHolder<P>>() {
    protected var items: MutableList<P> = ArrayList()
    private var callback: BaseAdapterCallback<P>? = null

    var hasItems = false

 fun setList(data: List<P>) {
        items.clear()
        items.addAll(data)
        hasItems = true
        notifyDataSetChanged()
    }

    fun addItem(item: P, position: Int = items.size - 1) {
        items.add(position, item)
        notifyItemInserted(position)
    }

    fun addItems(itemsForAdd: List<P>, position: Int = 0) {
        items.addAll(position, itemsForAdd)
        notifyItemRangeInserted(position, itemsForAdd.count())
    }

    fun updateItem(position: Int, newItem: P) {
        items[position] = newItem
        notifyItemChanged(position)
    }

    fun deleteItem(item: P) {
        val position = items.indexOf(item)
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun attachCallback(callback: BaseAdapterCallback<P>) {
        this.callback = callback
    }

    fun detachCallback() {
        this.callback = null
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: BaseViewHolder<P>, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            callback?.onItemClick(
                items[position],
                holder.itemView
            )
        }

        holder.itemView.setOnLongClickListener {
            if (callback == null) {
                false
            } else {
                callback!!.onLongClick(items[position], holder.itemView)
            }
        }
    }
}