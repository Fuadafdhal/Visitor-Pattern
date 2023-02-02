package com.afdhal_fa.visitorpattern.domain.walletmenu

import com.afdhal_fa.visitorpattern.base.VisitorUIModel
import com.afdhal_fa.visitorpattern.persentation.main.adapter.visitor.VisitorElement

data class WalletMenu(
    val balance: String,
    val pay: Pair<String, Int>,
    val topUp: Pair<String, Int>,
) : VisitorUIModel() {
    override fun type(type: VisitorElement): Int {
        return type.visit(this)
    }
}

