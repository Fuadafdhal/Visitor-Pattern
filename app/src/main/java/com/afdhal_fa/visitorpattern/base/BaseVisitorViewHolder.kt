package com.afdhal_fa.visitorpattern.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseVisitorViewHolder<in T>(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(data: T)
}