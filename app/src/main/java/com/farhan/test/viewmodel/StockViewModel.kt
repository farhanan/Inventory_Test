package com.farhan.test.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.farhan.test.base.BaseViewModel
import com.farhan.test.data.local.entity.Stock
import com.farhan.test.data.repository.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(
    application: Application,
  stockRepository: StockRepository
) : BaseViewModel(application) {
    private val repository = stockRepository

    fun insertLocalStock(stock: Stock) =
        viewModelScope.launch {
            repository.insertStockLocal(stock)
        }

    val getLocalStock
        get() = repository
            .getLocalStock()
            .asLiveData(viewModelScope.coroutineContext)

}