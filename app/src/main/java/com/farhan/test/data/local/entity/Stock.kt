package com.farhan.test.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.farhan.test.util.Const

@Entity(tableName = Const.Database.Table.STOCK)
data class Stock(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var name: String? = null,
    var stock: String? = null,
    var qty: String? = null,
    var transaction_type: String? = null,
    var create_by: String? = null,
    var date: String? = null,
)
