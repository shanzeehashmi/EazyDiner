package com.eazydiner.zeeproeazy.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eazydiner.zeeproeazy.MyApplication
import com.eazydiner.zeeproeazy.data.adapters.ShowcaseItemsAdapter
import com.eazydiner.zeeproeazy.data.db.entities.ItemsModel
import com.eazydiner.zeeproeazy.databinding.ActivityMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi


class MainActivity : AppCompatActivity() {

    private lateinit var itemsRecyclerView: RecyclerView
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter:ShowcaseItemsAdapter
    private lateinit var button:Button


    private val itemsViewModel : ItemsViewModel by viewModels  {
        ViewModelFactory((application as MyApplication).repository)
    }

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemsRecyclerView = binding.recyclerView
        button = binding.myItemsButton

        adapter = ShowcaseItemsAdapter(itemsViewModel)

        val layoutManager = LinearLayoutManager(this)
        itemsRecyclerView.layoutManager = layoutManager
        itemsRecyclerView.adapter = adapter

        itemsViewModel.getMenu().observe(this, {
            adapter.setProfiles(it)
        })

        button.setOnClickListener {
            startActivity(Intent(this,MyCheckedItemActivity::class.java))
        }



    }




}

