package com.example.shoppingapplication.model

import androidx.room.*


//specifying which table will be used

//here we specify the name and type of the database column
@Entity(tableName = "localshopdatabase")
data class ShoppingItem(@ColumnInfo(name= "productName") var productName: String,
                        @ColumnInfo(name="productAmount") var productAmount:Int){
    //necessity ! to be able to differentiate between each table
    @PrimaryKey(autoGenerate = true)
    var id:Int?= null
}