package com.ramo.sweetrecycler

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ramo.sweetrecycler.diffutils.IdentifiableDiffUtilCallBack
import com.ramo.sweetrecycler.diffutils.StandardDiffUtilCallBack

class SweetRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    var isPaginationEnable = false
    private var onScrollEnd: (() -> Unit)? = null

    init {
        setupPaging()
    }

    fun <T> render(
        onBind: (parent: ViewGroup, position: Int, data: T) -> SweetViewHolder<T>
    ) {
        adapter = SweetAdapter(onBind, StandardDiffUtilCallBack())
    }

    @JvmName("renderWithIdentifiableItem")
    fun <T : SweetDiff> render(
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
    fun <T> addData(list: List<T>) {
        val adapter = (adapter as? SweetAdapter<T>) ?: return
        val oldList = adapter.currentList.toMutableList()
        oldList.addAll(list)
        adapter.submitList(oldList.toList())
    }

    fun clearData() {
        val adapter = (adapter as? SweetAdapter<*>) ?: return
        adapter.submitList(listOf())
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> setOnItemClickListener(onItemClick: (view: View, position: Int, data: T) -> Unit) {
        (adapter as? SweetAdapter<T>)?.setOnItemClickListener(onItemClick)
    }

    fun onScrollEnd(func: () -> Unit) {
        onScrollEnd = func
    }

    private fun setupPaging() {
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (isPaginationEnable.not() || onScrollEnd == null) return
                val mLayoutManager = recyclerView.layoutManager ?: return
                val visibleItemCount = mLayoutManager.childCount
                val totalItemCount = mLayoutManager.itemCount
                var firstVisibleItemPosition = 0

                when (mLayoutManager) {
                    is StaggeredGridLayoutManager -> {
                        val firstVisibleItemPositions =
                            mLayoutManager.findFirstVisibleItemPositions(null)
                        // get maximum element within the list
                        firstVisibleItemPosition = firstVisibleItemPositions[0]
                    }
                    is GridLayoutManager -> {
                        firstVisibleItemPosition =
                            mLayoutManager.findFirstVisibleItemPosition()
                    }
                    is LinearLayoutManager -> {
                        firstVisibleItemPosition =
                            mLayoutManager.findFirstVisibleItemPosition()
                    }
                }
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= 0
                ) {
                    isPaginationEnable = false
                    onScrollEnd?.invoke()
                }
            }
        })
    }
}




