package com.farhan.test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farhan.test.data.local.dao.OrderDao
import com.farhan.test.data.local.dao.StockDao
import com.farhan.test.data.local.entity.Order
import com.farhan.test.data.local.entity.Stock

@Database(
    entities = [Order::class, Stock::class],
    version = 4,
    exportSchema = false
)
abstract class EfisheryDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
    abstract fun stockDao(): StockDao

}