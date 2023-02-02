package com.afdhal_fa.visitorpattern.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afdhal_fa.visitorpattern.persentation.main.adapter.visitor.VisitorElement

class BaseVisitorRecyclerViewAdapter constructor(
    /*as viewType identifier*/
    private val viewTypeElement: VisitorElement,


    /*the item data*/
    private val items: ArrayList<VisitorUIModel> = arrayListOf()
) : RecyclerView.Adapter<BaseVisitorViewHolder<VisitorUIModel>>() {

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseVisitorViewHolder<VisitorUIModel> {
        val layoutView = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return viewTypeElement.createViewHolder(
            layoutView,
            viewType
        ) as BaseVisitorViewHolder<VisitorUIModel>
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int = items[position].type(viewTypeElement)

    override fun onBindViewHolder(holder: BaseVisitorViewHolder<VisitorUIModel>, position: Int) {
        holder.onBind(items[position])
    }

    fun addItem(items: VisitorUIModel) {
        this.items.clear()
        this.items.add(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<VisitorUIModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}