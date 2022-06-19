package com.example.shoppingapplication.db

import ShoppingDAO
import android.content.Context
import androidx.room.*
import com.example.shoppingapplication.model.ShoppingItem


@Database(
    //specifying the database
   entities = [ShoppingItem::class],
    //specifying the version
    version = 1
)

abstract class ShoppingDB: RoomDatabase() {
    //function created here to call DAO class
    abstract fun getShoppingDAO(): ShoppingDAO
    //COMPANION ==>> SINGLETON
    companion object{
        //we either create the shoppingDB or keep it null
        //@volatile is used for multithreading
        @Volatile
        private var instance:ShoppingDB?= null
        //secret key for our database to be able to access it
        private val LOCK = Any()
        operator fun invoke (context: Context)= instance?: synchronized(LOCK){
            instance?: createDatabase(context).also {
                instance= it
            }
        }
        //this function will create for us a room database
        //we specify this to be its context
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDB::class.java,
                "localshopdatabase.dp"
            ).build()
    }

}