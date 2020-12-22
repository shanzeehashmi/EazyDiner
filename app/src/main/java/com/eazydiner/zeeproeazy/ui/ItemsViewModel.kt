package com.eazydiner.zeeproeazy.ui

import androidx.lifecycle.*
import com.eazydiner.zeeproeazy.data.db.entities.ItemsModel
import com.eazydiner.zeeproeazy.data.repository.ItemsRepository
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class ItemsViewModel(
    private val repository: ItemsRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.cleanRepo()
        }
    }

    private var foodItems:LiveData<List<ItemsModel>> = MutableLiveData()


    fun onCheckBoxClicked(item:ItemsModel)
    {
       checkBoxClicked(item)
    }

    fun getMenu() : LiveData<List<ItemsModel>>
    {
       getMenuFromRepo()
       return foodItems
    }

    private fun getMenuFromRepo()
    {
       foodItems =  repository.getMenuItemsFromServer().asLiveData()
    }


    private fun checkBoxClicked(item:ItemsModel)
    {
       foodItems.value?.let {
           val pos = it.indexOf(item)

           if(it[pos].marked)
           {
               viewModelScope.launch {
                   repository.removeItemFromRepo(item)
               }
           }
           else
           {
               viewModelScope.launch {
                   repository.putItemOnRepo(item)
               }
           }

           it[pos].marked = !it[pos].marked

       }
    }



}
