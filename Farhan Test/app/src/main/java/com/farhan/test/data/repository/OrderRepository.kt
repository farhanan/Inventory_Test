package com.farhan.test.data.repository

import com.farhan.test.data.local.entity.Order
import com.farhan.test.data.source.OrderLocalDataSource
import com.farhan.test.data.source.callback.OrderSourceCallback

class OrderRepository(
    localDataSource: OrderLocalDataSource
) : OrderSourceCallback {
    private val localDataSource = localDataSource

    override suspend fun insertOrderLocal(order: Order) = localDataSource.insertOrder(order)

    override fun getLocalOrder() = localDataSource.getOrder()
}