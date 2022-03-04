package com.ramo.demosweetrecycler

import android.view.ViewGroup
import com.ramo.demosweetrecycler.databinding.ItemProductBinding

class ProductViewHolder(
    viewGroup: ViewGroup
) : com.ramo.sweetrecycler.VBSweetViewHolder<ItemProductBinding, MyModel>(
    ItemProductBinding::inflate,
    viewGroup
) {

    override fun bind(data: MyModel) {
        binding.txtProductName.text = data.title
    }
}