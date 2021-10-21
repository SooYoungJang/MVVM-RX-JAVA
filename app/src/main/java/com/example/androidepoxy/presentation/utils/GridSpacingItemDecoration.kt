package com.example.androidepoxy.presentation.utils

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * epoxy recyclevier에서 아이템간의 간격을 설정.
 */
class GridSpacingItemDecoration(
    private val spacing: Int,
    private val isIncludeEdge: Boolean = false,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)  // 포지션은 각아이템의 포지션.
        val spanCount = (parent.layoutManager as? GridLayoutManager)?.spanCount ?: 0 //spanCount == HomeFragment 에서 GridLayoutManager 생성자에 넣어주었던 숫자.
        val column = position % spanCount
        if (isIncludeEdge) {
            outRect.left = spacing - column * spacing / spanCount
            outRect.right = (column + 1) * spacing / spanCount

            if (position < spanCount) {
                outRect.top = spacing;
            }
            outRect.bottom = spacing
        } else {
            outRect.left = column * spacing / spanCount
            outRect.right = spacing - (column + 1) * spacing / spanCount
            if (position >= spanCount) {
                outRect.top = spacing
            }
        }
    }
}