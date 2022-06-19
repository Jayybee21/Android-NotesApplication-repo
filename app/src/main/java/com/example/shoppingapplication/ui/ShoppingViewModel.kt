package com.example.shoppingapplication.ui

import androidx.lifecycle.ViewModel
import com.example.shoppingapplication.model.ShoppingItem
import com.example.shoppingapplication.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//VERY IMPORTANT TO MENTION VIEW MODEL
class ShoppingViewModel(private val repository: ShoppingRepository):ViewModel() {


    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repository.delete(item)
    }
    fun getAllShoppingItems() = repository.getAllShoppingItems()
}