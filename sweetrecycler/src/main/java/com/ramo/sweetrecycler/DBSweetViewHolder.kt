package com.ramo.sweetrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DBSweetViewHolder<DB : ViewDataBinding, T>(
    @LayoutRes layoutId: Int,
    viewGroup: ViewGroup?,
    private val _binding: DB? = DataBindingUtil.inflate(
        LayoutInflater.from(viewGroup?.context),
        layoutId,
        viewGroup,
        false
    )
) : SweetViewHolder<T>(
    _binding?.root!!
) {

    protected val binding: DB get() = _binding!!

}
