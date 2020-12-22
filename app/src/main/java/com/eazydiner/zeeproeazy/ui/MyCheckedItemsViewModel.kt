package com.eazydiner.zeeproeazy.ui

import android.util.Log
import androidx.lifecycle.*
import com.eazydiner.zeeproeazy.data.db.entities.ItemsModel
import com.eazydiner.zeeproeazy.data.repository.ItemsRepository
import com.eazydiner.zeeproeazy.utils.ShowToast
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class MyCheckedItemsViewModel(
    private val repository: ItemsRepository
) : ViewModel() {

    private var foodItems: LiveData<List<ItemsModel>> = MutableLiveData()

    @ExperimentalCoroutinesApi
    fun getItems(): LiveData<List<ItemsModel>> {
        getItemsFromRepo()
        return foodItems
    }

    fun getItemsFromRepo()
    {
        viewModelScope.launch {
            foodItems = repository.getItemsFromRepo()
        }
    }


}
