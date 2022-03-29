package main.app.fooddelivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import main.app.fooddelivery.databinding.ItemProductBinding
import main.app.fooddelivery.domain.models.ProductEntity

class ProductAdapter(
    private val clickListener: ItemClickListener,
    private val context: Context,
    private val view: View
) : ListAdapter<ProductEntity, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val packHolder = holder as ItemViewHolder
        packHolder.bind(item)
    }

    inner class ItemViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductEntity) {
            binding.apply {
                root.setOnClickListener {
                    it.isClickable = false
                    it.postDelayed({ it.isClickable = true }, 1000)
                    clickListener.onItemClicked(item, view)
                }

                productName.text = item.name
                productPrice.text = "From ${item.price.toString()} $"
                productDescription.text = item.description
            }
        }
    }

    interface ItemClickListener {
        fun onItemClicked(item: ProductEntity, view: View)
    }
}


class ItemsDiffCallback : DiffUtil.ItemCallback<ProductEntity>() {
    override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean =
        oldItem == newItem
}