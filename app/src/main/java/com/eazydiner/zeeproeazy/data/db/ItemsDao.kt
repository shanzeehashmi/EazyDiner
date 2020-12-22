package com.eazydiner.zeeproeazy.data.db

import androidx.room.*
import com.eazydiner.zeeproeazy.data.db.entities.ItemsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDao {

    @Query("SELECT * FROM my_orders ")
    fun getMyOrdersFromDatabase() : Flow<List<ItemsModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMyOrder(item:ItemsModel)

    @Query("DELETE FROM my_orders WHERE id = :id")
    suspend fun deleteMyOrder(id:Int)

    @Query("DELETE FROM my_orders")
    suspend fun deleteIfContainsAnything()


}