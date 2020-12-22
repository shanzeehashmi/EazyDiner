package com.eazydiner.zeeproeazy

import android.app.Application
import android.content.Context
import com.eazydiner.zeeproeazy.data.db.Database
import com.eazydiner.zeeproeazy.data.repository.ItemsRepository

class MyApplication : Application(){

    private val database by lazy { Database.getDatabase(this) }
    val repository by lazy { ItemsRepository(database) }

    companion object {
        lateinit var  myAppContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        myAppContext = applicationContext
    }

}