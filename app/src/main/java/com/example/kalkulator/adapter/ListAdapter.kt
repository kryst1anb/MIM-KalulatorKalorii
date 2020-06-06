package com.example.kalkulator.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.R
import com.example.kalkulator.db.Product

class ListAdapter(val products: List<Product>, val context: Context, val fragment: Fragment): RecyclerView.Adapter<ListAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.one_product,parent,false)
        return ViewHolder(v)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = products!![position]!!
        holder.item_name.text = product.name
        holder.nf_calories.text = product.kcal.toString()
        holder.nf_total_fat.text = product.fat.toString()
        holder.nf_protein.text = product.protein.toString()
        holder.nf_total_carbohydrate.text = product.carbo.toString()
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val item_name = itemView.findViewById<TextView>(R.id.item_name)
        val nf_calories = itemView.findViewById<TextView>(R.id.item_kcal)
        val nf_total_fat = itemView.findViewById<TextView>(R.id.item_fat)
        val nf_protein = itemView.findViewById<TextView>(R.id.item_protein)
        val nf_total_carbohydrate = itemView.findViewById<TextView>(R.id.item_carbo)
        val buttonDelProduct = itemView.findViewById<Button>(R.id.delete_product)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}