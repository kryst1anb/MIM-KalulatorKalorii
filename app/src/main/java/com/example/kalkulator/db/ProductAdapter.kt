package com.example.kalkulator.db

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.R

class ProductAdapter(private val recyclerView: RecyclerView, context: Context, val yp:Boolean) : RecyclerView.Adapter<ProductAdapter.ProductListViewHolder>() {

    val products = mutableListOf<Product>()

    var con: Context = context

    fun getContext(): Context
    {
        return con
    }

    class ProductListViewHolder(val item: View) : RecyclerView.ViewHolder(item)
    {
        public val nameFiled : TextView = item.findViewById(R.id.item_name)
        public val fatField : TextView = item.findViewById(R.id.item_fat)
        public val proteinField : TextView = item.findViewById(R.id.item_protein)
        public val carboField : TextView = item.findViewById(R.id.item_carbo)
        public val kcalField : TextView = item.findViewById(R.id.item_kcal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.one_item,parent,false)
        var row : LinearLayout = view.findViewById(R.id.one_item)

        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        var product : Product = products[position]

        holder.nameFiled.text = product.name
        holder.fatField.text = product.fat.toString()
        holder.proteinField.text = product.protein.toString()
        holder.carboField.text = product.carbo.toString()
        holder.kcalField.text = product.kcal.toString()
        holder.nameFiled.setSelected(true)
    }

    fun setProducts(newProductsList:List<Product>){
        products.clear()
        products.addAll(newProductsList)
        notifyDataSetChanged()
    }

    override fun getItemCount() = products.size
}