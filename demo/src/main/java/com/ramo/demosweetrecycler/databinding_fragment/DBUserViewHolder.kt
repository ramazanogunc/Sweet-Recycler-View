package com.ramo.demosweetrecycler.databinding_fragment

import android.view.ViewGroup
import com.ramo.demosweetrecycler.BR
import com.ramo.demosweetrecycler.MyModel
import com.ramo.demosweetrecycler.R
import com.ramo.sweetrecycler.DBSweetViewHolder

class DBUserViewHolder(
    viewGroup: ViewGroup
) : DBSweetViewHolder<MyModel>(
    R.layout.item_user_data_binding,
    viewGroup
) {
    override fun bind(data: MyModel) {
        binding.setVariable(BR.data, data)
        binding.executePendingBindings()
        // other bind and onclick callbacks
    }
}