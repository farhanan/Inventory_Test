package com.farhan.test.base

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Lifecycle
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import timber.log.Timber
import java.util.*

class BasePagingAdapter<T: Any,B: ViewBinding>(
    private var register: Register<T, B>,
    private var params: Params = Params(),
    diff: Diff<T>,
    bindingClass: Class<B>,
) : PagingDataAdapter<T, BasePagingAdapter<T,B>.ViewHolder>(DiffCallback(diff)) {

    private val bindingMethod = bindingClass.getMethod(
        BaseAdapter.INFLATE_METHOD,
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    )

    class DiffCallback<T>(private val diff: Diff<T>) : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T) =
            diff.areItemsTheSame.invoke(oldItem, newItem)

        override fun areContentsTheSame(oldItem: T, newItem: T) =
            diff.areContentsTheSame.invoke(oldItem, newItem)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BasePagingAdapter<T,B>.ViewHolder {

        val width = ((params.widthPercent / 100) * parent.width).toInt()
        val height = ((params.heightPercent / 100) * parent.width).toInt()

        val baseParams = LinearLayout.LayoutParams(
            if (params.widthPercent != 0.0) width else ViewGroup.LayoutParams.WRAP_CONTENT,
            if (params.heightPercent != 0.0) height else ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(
                params.margin.left,
                params.margin.top,
                params.margin.right,
                params.margin.bottom
            )
        }

        val inflater = LayoutInflater.from(parent.context)

        @Suppress("UNCHECKED_CAST")
        val viewBinding = bindingMethod.invoke(null, inflater, parent, false) as B

        viewBinding.root.apply {
            if (params.widthPercent != 0.0 || params.heightPercent != 0.0) {
                layoutParams = baseParams
            }
        }

        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: BasePagingAdapter<T,B>.ViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    inner class ViewHolder(private val binding: B): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T) {
            register.onBindHolder.invoke(bindingAdapterPosition, item, binding)

            binding.root.setOnClickListener {
                onItemClickCallback.invoke(binding, item, bindingAdapterPosition)
            }
        }
    }

    data class Register<T, B: ViewBinding>(
        var onBindHolder: (position: Int, item: T, binding: B) -> Unit,
        var asyncLayout: Boolean = false
    )

    data class Diff<T>(
        var areContentsTheSame: (old: T, new: T) -> Boolean,
        var areItemsTheSame: (old: T, new: T) -> Boolean
    )

    data class Params(
        var widthPercent: Double = 0.0,
        var heightPercent: Double = 0.0,
        var margin: Margin = Margin()
    ) {
        data class Margin(
            val top: Int = 0,
            val left: Int = 0,
            val right: Int = 0,
            val bottom: Int = 0
        )
    }

    private var onItemClickCallback: (binding: B, item: T, position: Int) -> Unit = { _, _, _ -> }

    fun setOnItemClickListener(callback: (view: B, item: T, position: Int) -> Unit) {
        onItemClickCallback = callback
    }

    companion object {
        suspend inline fun <T: Any, reified B : ViewBinding> simplePagingAdapterOf(
            register: Register<T, B>,
            diff: Diff<T>,
            params: Params = Params(),
            itemList: PagingData<T> = PagingData.empty(),
        ): BasePagingAdapter<T, B> {
            return BasePagingAdapter(register, params, diff, B::class.java).apply {
                if (itemList != PagingData.empty<T>()) submitData(itemList)
            }
        }

        inline fun <T: Any, reified B : ViewBinding> simplePagingAdapterOf(
            register: Register<T, B>,
            diff: Diff<T>,
            params: Params = Params(),
            lifecycle: Lifecycle,
            itemList: PagingData<T> = PagingData.empty(),
        ): BasePagingAdapter<T, B> {
            return BasePagingAdapter(register, params, diff, B::class.java).apply {
                if (itemList != PagingData.empty<T>()) submitData(lifecycle, itemList)
            }
        }
    }
}

// Todo @Bagus : Complete Base Paging Function For Multiple Item ViewType
class BasePagingItemViewAdapter<T: Any>(
    private val register: Register<T>,
    diff: Diff<T>
): PagingDataAdapter<T, RecyclerView.ViewHolder>(DiffCallback(diff)) {

    override fun getItemViewType(position: Int): Int {
        

        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class DiffCallback<T>(private val diff: Diff<T>): DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T) = diff.areItemsTheSame.invoke(oldItem, newItem)

        override fun areContentsTheSame(oldItem: T, newItem: T) = diff.areContentsTheSame.invoke(oldItem, newItem)
    }

    data class Register<T>(
        var ordinalClass: Map<Int, RecyclerView.ViewHolder>,
        var typeHolder: Map<Int, (position: Int, item: T, viewHolder: RecyclerView.ViewHolder) -> Unit>
    )

    data class Diff<T>(
        var areContentsTheSame: (old: T, new: T) -> Boolean,
        var areItemsTheSame: (old: T, new: T) -> Boolean
    )

    data class HolderHelper(
        var key: String,
        var value: Any?,
    )

    enum class HolderComponent {
        FIRST_ORDER,
        SECOND_ORDER;

        companion object {
            fun getHolderOrderByName(name: String?): HolderComponent? =
                name?.let { order ->
                    return try {
                        valueOf(order.toUpperCase(Locale.ROOT))
                    } catch (e: Exception) {
                        Timber.e(e)
                        null
                    }
                }
        }
    }
}