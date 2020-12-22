package com.eazydiner.zeeproeazy.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.eazydiner.zeeproeazy.data.db.entities.ItemsModel
import com.eazydiner.zeeproeazy.data.db.Database
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ItemsRepository(
    private val db : Database
){
    @ExperimentalCoroutinesApi
    fun getItemsFromRepo():LiveData<List<ItemsModel>>
    {
        return db.myOrders().getMyOrdersFromDatabase().asLiveData()
    }

    suspend fun putItemOnRepo(item: ItemsModel)
    {
        db.myOrders().insertMyOrder(item)
    }

    suspend fun removeItemFromRepo(item: ItemsModel)
    {
        db.myOrders().deleteMyOrder(item.id)
    }

    suspend fun cleanRepo()
    {
        db.myOrders().deleteIfContainsAnything()
    }



    @ExperimentalCoroutinesApi
    fun getMenuItemsFromServer() : Flow<List<ItemsModel>>
    {
        val items:MutableList<ItemsModel> = ArrayList()

        items.add(ItemsModel(1,"Veg Chowmin"))
        items.add(ItemsModel(2,"Egg Chowmin"))
        items.add(ItemsModel(3,"Fried Rice"))
        items.add(ItemsModel(4,"Chicken Chilly"))
        items.add(ItemsModel(5,"Spicy Chicken"))
        items.add(ItemsModel(6,"Pizza"))
        items.add(ItemsModel(7,"Burger"))
        items.add(ItemsModel(8,"Cold Coffee"))
        items.add(ItemsModel(9,"Hot Coffee"))
        items.add(ItemsModel(10,"Dark Coffee"))
        items.add(ItemsModel(11,"Egg Sandwich"))
        items.add(ItemsModel(12,"Gulab Jamun"))
        items.add(ItemsModel(13,"Noodles"))
        items.add(ItemsModel(14,"Jalebi"))
        items.add(ItemsModel(15,"Roast"))
        items.add(ItemsModel(16,"Rasmalai"))
        items.add(ItemsModel(17,"Tandoori chicken"))
        items.add(ItemsModel(18,"Veg Chowmin 1"))
        items.add(ItemsModel(19,"Veg Chowmin2"))
        items.add(ItemsModel(20,"Veg Chowmin3"))
        items.add(ItemsModel(21,"Veg Chowmin4"))
        items.add(ItemsModel(22,"Veg Chowmin5"))
        items.add(ItemsModel(23,"Veg Chowmin6"))
        items.add(ItemsModel(24,"Veg Chowmin7"))
        items.add(ItemsModel(25,"Veg Chowmin8"))
        items.add(ItemsModel(26,"Veg Chowmin9"))
        items.add(ItemsModel(27,"Veg Chowmin10"))
        items.add(ItemsModel(28,"Veg Chowmin11"))
        items.add(ItemsModel(29,"Veg Chowmin12"))
        items.add(ItemsModel(30,"Veg Chowmin13"))
        items.add(ItemsModel(31,"Veg Chowmin14"))
        items.add(ItemsModel(32,"Veg Chowmin15"))
        items.add(ItemsModel(33,"Veg Chowmin16"))


        return MutableStateFlow(items)

    }

}