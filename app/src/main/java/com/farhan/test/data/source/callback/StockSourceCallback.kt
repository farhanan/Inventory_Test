package com.farhan.test.data.source.callback

import com.farhan.test.data.local.entity.Stock
import kotlinx.coroutines.flow.Flow

interface StockSourceCallback {

    suspend fun insertStockLocal(stock: Stock)

    fun getLocalStock(): Flow<List<Stock>>

}