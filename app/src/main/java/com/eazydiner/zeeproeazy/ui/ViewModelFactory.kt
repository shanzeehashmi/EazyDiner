package com.eazydiner.zeeproeazy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eazydiner.zeeproeazy.data.repository.ItemsRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: ItemsRepository
    ) : ViewModelProvider.Factory    {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            return ItemsViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(MyCheckedItemsViewModel::class.java)) {
            return MyCheckedItemsViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}