package com.ramo.sweetrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class DBSweetViewHolder<T>(
    @LayoutRes layoutId: Int,
    viewGroup: ViewGroup?,
    private val onBindData: ((binding: ViewDataBinding, position: Int, data: T) -> Unit)? = null,
    private val _binding: ViewDataBinding? = DataBindingUtil.inflate(
        LayoutInflater.from(viewGroup?.context),
        layoutId,
        viewGroup,
        false
    )
) : SweetViewHolder<T>(
    _binding?.root!!
) {

    protected val binding: ViewDataBinding get() = _binding!!

    open override fun bind(data: T) {
        onBindData?.invoke(binding, adapterPosition, data)
    }

}
