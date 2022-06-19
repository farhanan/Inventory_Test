package com.farhan.test.ui.mutation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.farhan.test.R
import com.farhan.test.data.local.entity.Stock
import com.farhan.test.databinding.FragmentMutationBinding
import com.farhan.test.ui.stock.StockAdapter
import com.farhan.test.util.viewBinding
import com.farhan.test.viewmodel.StockViewModel
import timber.log.Timber

class MutationFragment : Fragment(R.layout.fragment_mutation) {

    private val binding by viewBinding<FragmentMutationBinding>()
    private val viewModel by hiltNavGraphViewModels<StockViewModel>(R.id.profile)
    private val stockAdapter = StockAdapter.stockMutationAdapter

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