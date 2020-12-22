package com.eazydiner.zeeproeazy.ui

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eazydiner.zeeproeazy.MyApplication
import com.eazydiner.zeeproeazy.R
import com.eazydiner.zeeproeazy.data.adapters.MyCheckedItemsAdapter
import com.eazydiner.zeeproeazy.data.adapters.ShowcaseItemsAdapter
import com.eazydiner.zeeproeazy.databinding.ActivityMainBinding
import com.eazydiner.zeeproeazy.databinding.ActivityMyCheckedItemBinding
import com.eazydiner.zeeproeazy.utils.ShowToast
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MyCheckedItemActivity : AppCompatActivity() {

    private lateinit var itemsRecyclerView: RecyclerView
    private lateinit var binding: ActivityMyCheckedItemBinding
    private lateinit var adapter: MyCheckedItemsAdapter
    private lateinit var back_button: ImageView

    @ExperimentalCoroutinesApi
    private val itemsViewModel : MyCheckedItemsViewModel by viewModels  {
        ViewModelFactory((application as MyApplication).repository)
    }

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCheckedItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ShowToast("Checked Items will be shown here")

        itemsRecyclerView = binding.recyclerView
        back_button = binding.backButton

        itemsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyCheckedItemsAdapter()
        itemsRecyclerView.adapter = adapter

        itemsViewModel.getItems().observe(this, {
            adapter.setProfiles(it)
        })

        back_button.setOnClickListener {
            onBackPressed()
        }

    }
}