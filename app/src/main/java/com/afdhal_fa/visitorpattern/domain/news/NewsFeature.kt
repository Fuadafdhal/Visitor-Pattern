package com.afdhal_fa.visitorpattern.domain.news

import com.afdhal_fa.visitorpattern.base.VisitorUIModel
import com.afdhal_fa.visitorpattern.persentation.main.adapter.visitor.VisitorElement

data class NewsFeature(
    val newsList: List<News>
):VisitorUIModel() {
    override fun type(type: VisitorElement): Int {
        return type.visit(this)
    }
}