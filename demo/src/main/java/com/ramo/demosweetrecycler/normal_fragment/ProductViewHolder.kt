package com.ramo.demosweetrecycler.normal_fragment

import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.ramo.demosweetrecycler.MyModel
import com.ramo.demosweetrecycler.R
import com.ramo.sweetrecycler.SweetViewHolder

class ProductViewHolder(
    viewGroup: ViewGroup
) : SweetViewHolder<MyModel>(
    R.layout.item_product,
    viewGroup
) {
    override fun bind(data: MyModel) {
        itemView.findViewById<AppCompatTextView>(R.id.txtProductName).text = data.title
        // other bind and onclick callbacks
    }
}