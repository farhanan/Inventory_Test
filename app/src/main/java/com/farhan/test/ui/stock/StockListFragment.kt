package com.farhan.test.ui.stock

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.farhan.test.R
import com.farhan.test.data.local.entity.Stock
import com.farhan.test.databinding.FragmentStockListBinding
import com.farhan.test.util.viewBinding
import com.farhan.test.viewmodel.StockViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class StockListFragment : Fragment(R.layout.fragment_stock_list) {

    private val binding by viewBinding<FragmentStockListBinding>()
    private val viewModel by hiltNavGraphViewModels<StockViewModel>(R.id.cart)
    private val stockAdapter = StockAdapter.stockAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        localDataOrder()
    }

    private fun localDataOrder() {
        var data = emptyList<Stock>()
        viewModel.getLocalStock.observe(viewLifecycleOwner) { result ->
            Timber.e(result.toString())
            data = result.orEmpty()
            stockAdapter.items = data
        }
        binding.rvOrder.adapter = stockAdapter
    }

}