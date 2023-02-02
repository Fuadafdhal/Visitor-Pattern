package com.afdhal_fa.visitorpattern.persentation.main.adapter.visitor

import android.view.View
import com.afdhal_fa.visitorpattern.base.BaseVisitorViewHolder
import com.afdhal_fa.visitorpattern.domain.news.News
import com.afdhal_fa.visitorpattern.domain.news.NewsFeature
import com.afdhal_fa.visitorpattern.domain.walletmenu.WalletMenu

interface VisitorElement {

    fun visit(walletMenu: WalletMenu): Int

    fun visit(newsFeature: NewsFeature): Int

    //factory
    fun createViewHolder(parent: View, type: Int): BaseVisitorViewHolder<*>
}