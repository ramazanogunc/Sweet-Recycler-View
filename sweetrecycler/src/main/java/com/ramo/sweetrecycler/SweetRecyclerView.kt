package com.ramo.sweetrecycler

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramo.sweetrecycler.diffutils.IdentifiableDiffUtilCallBack
import com.ramo.sweetrecycler.diffutils.StandardDiffUtilCallBack

class SweetRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    fun <T> render(
        onBind: (parent: ViewGroup, position: Int, data: T) -> SweetViewHolder<T>
    ) {
        adapter = SweetAdapter(onBind, StandardDiffUtilCallBack())
    }

    @JvmName("renderWithIdentifiableItem")
    fun <T : Identifiable> render(
        onBind: (parent: ViewGroup, position: Int, data: T) -> SweetViewHolder<T>
    ) {
        adapter = SweetAdapter(onBind, IdentifiableDiffUtilCallBack())
    }

    @SuppressLint("NotifyDataSetChanged")
    fun notifyDataSetChanged() {
        adapter?.notifyDataSetChanged()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> setData(list: List<T>) {
        (adapter as? SweetAdapter<T>)?.submitList(list)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> setOnItemClickListener(onItemClick: (view: View, position: Int, data: T) -> Unit) {
        (adapter as? SweetAdapter<T>)?.setOnItemClickListener(onItemClick)
    }
}




