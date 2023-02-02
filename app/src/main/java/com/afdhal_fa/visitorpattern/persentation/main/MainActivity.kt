package com.afdhal_fa.visitorpattern.persentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.afdhal_fa.visitorpattern.R
import com.afdhal_fa.visitorpattern.base.BaseVisitorRecyclerViewAdapter
import com.afdhal_fa.visitorpattern.databinding.ActivityMainBinding
import com.afdhal_fa.visitorpattern.domain.news.News
import com.afdhal_fa.visitorpattern.domain.news.NewsFeature
import com.afdhal_fa.visitorpattern.domain.walletmenu.WalletMenu
import com.afdhal_fa.visitorpattern.persentation.main.adapter.visitor.VisitorElementFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val homeAdapter by lazy {
        BaseVisitorRecyclerViewAdapter(
            VisitorElementFactory(
                onBalanceClick = ::onBalanceClick,
                onPayClick = ::onPayClick,
                onTopUpClick = ::onTopUpClick,
                onNewsItemClick = ::onNewsItemClick,
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initListView()
    }

    private fun initRecyclerView() {
        with(binding.rvHome) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = homeAdapter
        }
    }

    private fun initListView() {
        val walletMenu = WalletMenu(
            "Rp 20.000",
            Pair("Pay", R.drawable.ic_launcher_foreground),
            Pair("Top Up", R.drawable.ic_launcher_foreground)
        )

        val newsFeature = NewsFeature(generateNewsData())

        homeAdapter.addItems(listOf(walletMenu, newsFeature))
    }

    private fun generateNewsData(): List<News> {
        val newsItems = mutableListOf<News>()
        for (i in 0 until 5) {
            newsItems.add(
                News(
                    "Lorem News #$i",
                    R.drawable.ic_launcher_background,
                    "Lorem Ipsum dolor"
                )
            )
        }
        return newsItems
    }

    private fun onBalanceClick(balance: String) {
        Toast.makeText(this, balance, Toast.LENGTH_SHORT).show()
    }

    private fun onPayClick() {
        Toast.makeText(this, "Direct To Scan QR Page", Toast.LENGTH_SHORT).show()
    }

    private fun onTopUpClick() {
        Toast.makeText(this, "Direct To TopUp Page", Toast.LENGTH_SHORT).show()
    }

    private fun onNewsItemClick(news: News) {
        Toast.makeText(this, news.label, Toast.LENGTH_SHORT).show()
    }

}