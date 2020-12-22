package com.eazydiner.zeeproeazy.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eazydiner.zeeproeazy.data.db.entities.ItemsModel

@androidx.room.Database(entities = [ItemsModel::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun myOrders(): ItemsDao

    companion object {
        @Volatile
        private var INSTANCE: Database? = null

        fun getDatabase(context: Context): Database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java,
                    "eazy_diner_pro_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}