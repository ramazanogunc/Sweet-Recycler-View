package com.ramo.sweetrecycler.diffutils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.ramo.sweetrecycler.SweetDiff

class IdentifiableDiffUtilCallBack<T : SweetDiff> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.diffId == newItem.diffId

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}
