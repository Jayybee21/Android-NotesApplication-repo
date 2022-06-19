package com.example.shoppingapplication.repository

import com.example.shoppingapplication.db.ShoppingDB
import com.example.shoppingapplication.model.ShoppingItem


//bridge class between data and view model
class ShoppingRepository (private val db:ShoppingDB){

    suspend fun upsert(item:ShoppingItem) = db.getShoppingDAO().upsert(item)
    suspend fun delete(item:ShoppingItem) = db.getShoppingDAO().delete(item)
    //it returns all data so no need to specify anything in parentheses
    fun getAllShoppingItems() = db.getShoppingDAO().getAllShoppingItems()

}