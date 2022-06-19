package com.farhan.test.ui.stock

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.farhan.test.R
import com.farhan.test.data.local.entity.Stock
import com.farhan.test.databinding.FragmentInputItemBinding
import com.farhan.test.util.emptyString
import com.farhan.test.util.textOrNull
import com.farhan.test.util.timePicker
import com.farhan.test.util.viewBinding
import com.farhan.test.viewmodel.StockViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddStockFragment : Fragment(R.layout.fragment_input_item) {

    private val binding by viewBinding<FragmentInputItemBinding>()
    private val viewModel by hiltNavGraphViewModels<StockViewModel>(R.id.home)

    private val date = SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("IN"))

    private var stock: Stock = Stock()
    private var transaction = emptyString

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initOnClick()
        initView()
    }

    private fun initView() {
        initSpinnerSort()
    }

    private fun datePicker(chosenDate: Long?) {
        childFragmentManager.timePicker(
            selection = chosenDate,
            constraint = Pair(null, Date().time)
        ) {
            val format = date.format(Date(it))

            binding.tvDate.textOrNull = format
        }
    }

    private fun initSpinnerSort() {
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.transaction,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnertransaction.adapter = adapter

        binding.spinnertransaction.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    transaction = binding.spinnertransaction.selectedItem.toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
    }


    private fun initOnClick() {
        binding.apply {
            btnSave.setOnClickListener(onClickCallback)
            clDateBirth.setOnClickListener(onClickCallback)
        }
    }

    private val onClickCallback = View.OnClickListener { view ->
        when (view) {
            binding.btnSave -> {
                stock = Stock(
                    name = binding.etName.text.toString(),
                    stock = binding.etStock.text.toString(),
                    qty = binding.etQty.text.toString(),
                    transaction_type = transaction,
                    create_by = binding.etCreate.text.toString(),
                    date = binding.tvDate.text.toString(),

                )
                viewModel.insertLocalStock(stock)
//                dismiss()
                Timber.e(stock.toString())
            }
            binding.clDateBirth -> datePicker(Date().time)
        }
    }

}