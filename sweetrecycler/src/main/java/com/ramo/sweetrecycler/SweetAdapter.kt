package com.ramo.sweetrecycler

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

open class SweetAdapter<T>(
    private val onBind: ((ViewGroup, Int, T) -> SweetViewHolder<T>),
    diffUtilCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, SweetViewHolder<T>>(diffUtilCallback) {

    private var onItemClick: ((view: View, position: Int, data: T) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SweetViewHolder<T> {
        val holder = onBind.invoke(parent, position, getItem(position))
        if (onItemClick != null)
            holder.itemView.setOnClickListener {
                onItemClick?.invoke(it, position, getItem(position))
            }
        return holder
    }


    override fun onBindViewHolder(holder: SweetViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int = position

    fun setOnItemClickListener(onItemClick: (view: View, position: Int, data: T) -> Unit) {
        this.onItemClick = onItemClick
    }

}