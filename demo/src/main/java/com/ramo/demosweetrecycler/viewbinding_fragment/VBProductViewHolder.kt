package com.ramo.demosweetrecycler.viewbinding_fragment

import android.view.ViewGroup
import com.ramo.demosweetrecycler.MyModel
import com.ramo.demosweetrecycler.databinding.ItemProductBinding
import com.ramo.demosweetrecycler.databinding.ItemUserBinding
import com.ramo.sweetrecycler.VBSweetViewHolder

class VBProductViewHolder(
    viewGroup: ViewGroup
) : VBSweetViewHolder<ItemProductBinding, MyModel>(
    ItemProductBinding::inflate,
    viewGroup
) {

    override fun bind(data: MyModel) {
        binding.txtProductName.text = data.title
        // other bind and onclick callbacks
    }

}