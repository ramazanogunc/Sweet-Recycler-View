package com.ramo.sweetrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class SweetViewHolder<T>(
    view: View
) : RecyclerView.ViewHolder(view) {

    constructor(
        @LayoutRes layoutId: Int,
        viewGroup: ViewGroup?
    ) : this(
        LayoutInflater.from(viewGroup?.context).inflate(layoutId, viewGroup, false)
    )

    abstract fun bind(data: T)
}