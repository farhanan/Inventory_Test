package com.farhan.test.data.repository

import com.farhan.test.data.local.entity.Stock
import com.farhan.test.data.source.StockLocalDataSource
import com.farhan.test.data.source.callback.StockSourceCallback

class StockRepository(
    localDataSource: StockLocalDataSource
) : StockSourceCallback {
    private val localDataSource = localDataSource

    override suspend fun insertStockLocal(stock: Stock) = localDataSource.insertStock(stock)

    override fun getLocalStock() = localDataSource.getStock()
}