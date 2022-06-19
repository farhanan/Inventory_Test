package com.farhan.test.data.source

import com.farhan.test.data.local.dao.StockDao
import com.farhan.test.data.local.entity.Stock

class StockLocalDataSource(
    stockDao: StockDao
) {
    private val daoStock = stockDao

    suspend fun insertStock(stock: Stock) = daoStock.insertStock(stock)

    fun getStock() = daoStock.getStock()
}