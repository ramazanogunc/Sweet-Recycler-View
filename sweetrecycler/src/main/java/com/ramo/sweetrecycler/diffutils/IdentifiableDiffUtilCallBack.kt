package com.ramo.sweetrecycler.diffutils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.ramo.sweetrecycler.Identifiable

class IdentifiableDiffUtilCallBack<T : Identifiable> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}
