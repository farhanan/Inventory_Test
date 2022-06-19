package com.farhan.test.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farhan.test.data.local.entity.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserOrder(order: Order)

    @Query("SELECT * FROM ORDER_ENTITY")
    fun getOrder(): Flow<List<Order>>
}