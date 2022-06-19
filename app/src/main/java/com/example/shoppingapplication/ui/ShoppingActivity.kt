package com.example.shoppingapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapplication.databinding.ActivityShoppingBinding
import com.example.shoppingapplication.db.ShoppingDB
import com.example.shoppingapplication.model.ShoppingItem
import com.example.shoppingapplication.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //getting an instance of db
        val database = ShoppingDB(this)
        //getting an instance of shop view model
        val repository = ShoppingRepository(database)
        //getting an instance of factory class
        val factory = ShoppingViewModelFactory(repository)
        //variable to talk with view model -> repository -> DAO
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)
        //Calling the adapter
        val adapter = ShoppingItemAdapter(listOf(),viewModel)
        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer{
            adapter.items = it
            //update
            adapter.notifyDataSetChanged()
        })

        binding.fabAddShoppingItems.setOnClickListener{
            AddShoppingItemClass(this,object :AddDialogListener{
                override fun onButtonClicked(item: ShoppingItem){
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}