package com.eazydiner.zeeproeazy.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "my_orders")
data class ItemsModel(
    @PrimaryKey
    val id: Int,
    val item_name:String,
    var marked:Boolean = false
)