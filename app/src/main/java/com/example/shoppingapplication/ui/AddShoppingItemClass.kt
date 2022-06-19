package com.example.shoppingapplication.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingapplication.databinding.DialogAddNewItemBinding
import com.example.shoppingapplication.model.ShoppingItem

class AddShoppingItemClass(context: Context,var addDialogListener: AddDialogListener):AppCompatDialog(context) {
    private lateinit var binding: DialogAddNewItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddNewItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAdd.setOnClickListener {
           var newShoppingItemName = binding.etItemAmount.text.toString()
            var newShoppingItemAmount =  binding.etItemName.text.toString()
            if (newShoppingItemName.isEmpty() || newShoppingItemAmount.isEmpty()){
                Toast.makeText(context ,"Info is missing ! ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var item = ShoppingItem(newShoppingItemName,newShoppingItemAmount.toInt())
            addDialogListener.onButtonClicked(item)
            dismiss()

        }

        binding.btnCancel.setOnClickListener{
        }
    }
}