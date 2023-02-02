package com.afdhal_fa.visitorpattern.persentation.main.adapter.visitor

import android.view.View
import com.afdhal_fa.visitorpattern.base.BaseVisitorViewHolder
import com.afdhal_fa.visitorpattern.domain.news.News
import com.afdhal_fa.visitorpattern.domain.news.NewsFeature
import com.afdhal_fa.visitorpattern.domain.walletmenu.WalletMenu
import com.afdhal_fa.visitorpattern.persentation.main.adapter.viewholder.NewsFeatureViewHolder
import com.afdhal_fa.visitorpattern.persentation.main.adapter.viewholder.WalletMenuViewHolder

class VisitorElementFactory(
    private val onBalanceClick: (String) -> Unit,
    private val onPayClick: () -> Unit,
    private val onTopUpClick: () -> Unit,
    private val onNewsItemClick: (News) -> Unit
) : VisitorElement {
    override fun visit(walletMenu: WalletMenu): Int {
        return WalletMenuViewHolder.LAYOUT
    }

    override fun visit(newsFeature: NewsFeature): Int {
        return NewsFeatureViewHolder.LAYOUT
    }

    override fun createViewHolder(parent: View, type: Int): BaseVisitorViewHolder<*> {
        return when (type) {
            WalletMenuViewHolder.LAYOUT -> WalletMenuViewHolder(
                parent,
                onBalanceClick,
                onPayClick,
                onTopUpClick
            )
            NewsFeatureViewHolder.LAYOUT -> NewsFeatureViewHolder(parent, onNewsItemClick)
            else -> createViewHolder(parent, type)
        }
    }
}