package com.ramo.sweetrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

open class VBSweetViewHolder<VB : ViewBinding, T>(
    inflater: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    viewGroup: ViewGroup?,
    private val onBindData: ((binding: VB, position: Int, data: T) -> Unit)? = null,
    private val _binding: VB? = inflater.invoke(
        LayoutInflater.from(viewGroup?.context),
        viewGroup,
        false
    )
) : SweetViewHolder<T>(
    _binding?.root!!
) {

    protected val binding: VB get() = _binding!!

    open override fun bind(data: T) {
        onBindData?.invoke(binding, adapterPosition, data)
    }

}


