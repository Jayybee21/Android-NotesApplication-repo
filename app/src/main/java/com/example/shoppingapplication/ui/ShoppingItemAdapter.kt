package com.example.shoppingapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapplication.databinding.SingleItemLayoutBinding
import com.example.shoppingapplication.model.ShoppingItem

//step1 : specify parameters of class to be list of shopping item
class ShoppingItemAdapter(var items:List<ShoppingItem>, private val viewmodel: ShoppingViewModel):RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    //step2 : create an inner class that acts like activity but for recycler view's single item xml file
    inner class ShoppingViewHolder(val binding:SingleItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    //step3 create the view holder, specify what to read and exactly how the form is via context of parent
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(SingleItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    //step4: the function that scopes out which item exactly I am interacting with
    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        var currentShoppingItem = items[position]

        //now we link the viewholder stuff to the xml texts
        holder.binding.txtItemName.text = currentShoppingItem.productName
        holder.binding.txtItemAmount.text = "${currentShoppingItem.productAmount}"
        holder.binding.btnDeleteFromCart.setOnClickListener{
            viewmodel.delete(currentShoppingItem)
        }
        holder.binding.btnIncrementToCart.setOnClickListener{
            currentShoppingItem.productAmount++
            viewmodel.upsert(currentShoppingItem)
        }
        holder.binding.btnDecrementFromCart.setOnClickListener{
            if(currentShoppingItem.productAmount > 0){
            currentShoppingItem.productAmount--
            viewmodel.upsert(currentShoppingItem)
        }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}