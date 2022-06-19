package com.farhan.test.ui.stock

import com.farhan.test.base.BaseAdapter
import com.farhan.test.data.local.entity.Stock
import com.farhan.test.databinding.ItemStockBinding
import com.farhan.test.databinding.ItemStockMutationBinding
import com.farhan.test.util.textOrNull

object StockAdapter {
    val stockAdapter =
        BaseAdapter.adapterOf<Stock, ItemStockBinding>(
            register = BaseAdapter.Register(
                onBindHolder = { pos, item, view ->
                    view.run {
                        tvName.textOrNull = "Name :" + "" + item.name
                        tvStock.textOrNull = "Stock :" + "" + item.stock
                    }
                }
            ),
            diff = BaseAdapter.Diff(
                areItemsTheSame = { old, new -> old.id == new.id },
                areContentsTheSame = { old, new -> old == new }
            )
        )

    val stockMutationAdapter =
        BaseAdapter.adapterOf<Stock, ItemStockMutationBinding>(
            register = BaseAdapter.Register(
                onBindHolder = { pos, item, view ->
                    view.run {
                        tvQty.textOrNull = "Qty :" + "" + item.qty
                        tvCreate.textOrNull = "Dibuat oleh :" + "" + item.create_by
                        tvTransactionType.textOrNull = "Transaction :" + "" + item.create_by
                        tvDate.textOrNull = "Date :" + "" + item.create_by
                    }
                }
            ),
            diff = BaseAdapter.Diff(
                areItemsTheSame = { old, new -> old.id == new.id },
                areContentsTheSame = { old, new -> old == new }
            )
        )
}