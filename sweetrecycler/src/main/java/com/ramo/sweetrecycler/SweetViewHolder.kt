package com.ramo.sweetrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

open class SweetViewHolder<T>(
    view: View,
    private val onBindData: ((view: View, position: Int, data: T) -> Unit)? = null
) : RecyclerView.ViewHolder(view) {

    constructor(
        @LayoutRes layoutId: Int,
        viewGroup: ViewGroup?,
        onBindData: ((view: View, position: Int, data: T) -> Unit)? = null
    ) : this(
        LayoutInflater.from(viewGroup?.context).inflate(layoutId, viewGroup, false),
        onBindData
    )

    open fun bind(data: T) {
        onBindData?.invoke(itemView, adapterPosition, data)
    }
}