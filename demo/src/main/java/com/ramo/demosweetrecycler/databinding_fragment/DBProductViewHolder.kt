package com.ramo.demosweetrecycler.databinding_fragment

import android.view.ViewGroup
import com.ramo.demosweetrecycler.BR
import com.ramo.demosweetrecycler.MyModel
import com.ramo.demosweetrecycler.R
import com.ramo.demosweetrecycler.databinding.ItemProductDataBindingBinding
import com.ramo.sweetrecycler.DBSweetViewHolder

class DBProductViewHolder(
    viewGroup: ViewGroup
) : DBSweetViewHolder<ItemProductDataBindingBinding, MyModel>(
    R.layout.item_product_data_binding,
    viewGroup
) {
    override fun bind(data: MyModel) {
        binding.setVariable(BR.data, data)
        binding.executePendingBindings()
        // other bind and onclick callbacks
    }
}