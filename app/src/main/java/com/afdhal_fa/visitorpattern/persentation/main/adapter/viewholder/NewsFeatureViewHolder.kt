package com.afdhal_fa.visitorpattern.persentation.main.adapter.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import com.afdhal_fa.visitorpattern.R
import com.afdhal_fa.visitorpattern.base.BaseVisitorViewHolder
import com.afdhal_fa.visitorpattern.databinding.ItemNewsFeatureBinding
import com.afdhal_fa.visitorpattern.domain.news.News
import com.afdhal_fa.visitorpattern.domain.news.NewsFeature
import com.afdhal_fa.visitorpattern.persentation.main.adapter.NewsAdapter

class NewsFeatureViewHolder(
    view: View,
    private val onItemClick: (News) -> Unit
) : BaseVisitorViewHolder<NewsFeature>(view) {
    private val binding = ItemNewsFeatureBinding.bind(view)
    private val newsAdapter: NewsAdapter by lazy {
        NewsAdapter(onItemClick)
    }

    override fun onBind(data: NewsFeature) {
        with(binding) {
            rvNews.setHasFixedSize(true)
            rvNews.adapter = newsAdapter
            rvNews.layoutManager = LinearLayoutManager(
                root.context, LinearLayoutManager.HORIZONTAL, false
            )
            newsAdapter.setItem(data.newsList.toMutableList())
        }
    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.item_news_feature
    }
}
