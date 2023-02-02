package com.afdhal_fa.visitorpattern.persentation.main.adapter.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import com.afdhal_fa.visitorpattern.R
import com.afdhal_fa.visitorpattern.base.BaseVisitorViewHolder
import com.afdhal_fa.visitorpattern.databinding.ItemWalletMenuBinding
import com.afdhal_fa.visitorpattern.domain.walletmenu.WalletMenu

class WalletMenuViewHolder(
    view: View,
    private val onBalanceClick: (String) -> Unit,
    private val onPayClick: () -> Unit,
    private val onTopUpClick: () -> Unit
) : BaseVisitorViewHolder<WalletMenu>(view) {
    private val binding = ItemWalletMenuBinding.bind(view)
    override fun onBind(data: WalletMenu) {
        with(binding) {
            tvBalance.text = data.balance

            tvLabelPay.text = data.pay.first
            ivPay.setImageDrawable(
                ContextCompat.getDrawable(binding.root.context, data.pay.second)
            )

            tvLabelTopUp.text = data.topUp.first
            ivTopUp.setImageDrawable(
                ContextCompat.getDrawable(binding.root.context, data.topUp.second)
            )

            tvBalance.setOnClickListener {
                onBalanceClick.invoke(data.balance)
            }

            containerPay.setOnClickListener {
                onPayClick.invoke()
            }

            containerTopUp.setOnClickListener {
                onTopUpClick.invoke()
            }
        }
    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.item_wallet_menu
    }
}