package com.afdhal_fa.visitorpattern.persentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.afdhal_fa.visitorpattern.base.BaseRecyclerViewAdapter
import com.afdhal_fa.visitorpattern.databinding.ItemNewsBinding
import com.afdhal_fa.visitorpattern.domain.news.News

class NewsAdapter(
    private val onItemClicked: (News) -> Unit
) : BaseRecyclerViewAdapter<NewsAdapter.NewsViewHolder, News>() {

    inner class NewsViewHolder(private val binding: ItemNewsBinding) : ViewHolder(binding.root) {
        fun onBind(news: News) {
            with(binding) {
                tvTitle.text = news.label
                tvDescription.text = news.description
                ivNews.setImageDrawable(
                    ContextCompat.getDrawable(binding.root.context, news.image)
                )
                root.setOnClickListener { onItemClicked.invoke(news) }
            }
        }
    }

    override fun onBindViewHolder(holder: NewsViewHolder, item: News, position: Int) {
        holder.onBind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}