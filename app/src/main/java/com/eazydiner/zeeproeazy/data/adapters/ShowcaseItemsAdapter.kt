package com.eazydiner.zeeproeazy.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eazydiner.zeeproeazy.R
import com.eazydiner.zeeproeazy.data.db.entities.ItemsModel
import com.eazydiner.zeeproeazy.databinding.LayoutItemsBinding
import com.eazydiner.zeeproeazy.ui.ItemsViewModel

class ShowcaseItemsAdapter(
 viewModel:ItemsViewModel
): RecyclerView.Adapter<ShowcaseItemsAdapter.ItemsViewHolder>()  {

    private var items: List<ItemsModel>? = null
    private val viewModel:ItemsViewModel = viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemsViewHolder{
        val binding = createBinding(parent, viewType)
        return ItemsViewHolder(binding)
    }

    private fun createBinding(parent: ViewGroup, viewType: Int): LayoutItemsBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_items, parent,
            false
        )
    }

    override fun getItemCount() = items?.size ?: 0

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        items?.let {
            holder.binding.recommendedItems = it[position]
            holder.binding.itemsViewModel = viewModel
            holder.binding.executePendingBindings()
        }
    }

    fun setProfiles(profiles: List<ItemsModel>) {
        val temp:Int = profiles.size
        this.items = profiles
        notifyItemRangeInserted(temp,profiles.size)
    }

    class ItemsViewHolder(val binding: LayoutItemsBinding) :
        RecyclerView.ViewHolder(binding.root)


}