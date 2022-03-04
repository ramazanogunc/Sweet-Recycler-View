package com.ramo.demosweetrecycler.viewbinding_fragment

import android.view.ViewGroup
import com.ramo.demosweetrecycler.MyModel
import com.ramo.demosweetrecycler.databinding.ItemUserBinding
import com.ramo.sweetrecycler.VBSweetViewHolder

class VBUserViewHolder(
    viewGroup: ViewGroup
) : VBSweetViewHolder<ItemUserBinding, MyModel>(
    ItemUserBinding::inflate,
    viewGroup
) {
    override fun bind(data: MyModel) {
        binding.txtUsername.text = data.title
        // other bind and onclick callbacks
    }
}