package com.farhan.test.data.source.callback

import com.farhan.test.data.local.entity.Order
import kotlinx.coroutines.flow.Flow

interface OrderSourceCallback {

    suspend fun insertOrderLocal(order: Order)

    fun getLocalOrder(): Flow<List<Order>>

}