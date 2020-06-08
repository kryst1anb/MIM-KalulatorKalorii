package com.example.kalkulator.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.R
import com.example.kalkulator.db.Product
import com.example.kalkulator.db.ProductDB
import com.example.kalkulatorkalorii.json.ResultProductList
import kotlin.math.log

class SearchingListAdapter(val products: ResultProductList, val context: Context) : RecyclerView.Adapter<SearchingListAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.one_item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.listItems?.hits
        val item_name = product?.get(position)?.fields?.itemName
        val nf_calories = product?.get(position)?.fields?.nfCalories
        val nf_total_fat = product?.get(position)?.fields?.nfTotalFat
        val nf_protein = product?.get(position)?.fields?.nfProtein
        val nf_total_carbohydrate = product?.get(position)?.fields?.nfTotalCarbohydrate
        holder.item_name.text = item_name.toString()
        holder.nf_calories.text =  nf_calories.toString()
        holder.nf_total_fat.text =  nf_total_fat.toString()
        holder.nf_protein.text =  nf_protein.toString()
        holder.nf_total_carbohydrate.text =  nf_total_carbohydrate.toString()

        holder.buttonAddProduct.setOnClickListener {
            Thread {
                val db = ProductDB.getInstance(context)
                val insertProduct = Product(null, item_name!!, nf_calories!!, nf_total_fat!!, nf_protein!!, nf_total_carbohydrate!!)
                db.productDAO().insert(insertProduct)

            }.start()
            Toast.makeText(context, "Product added", Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val item_name = itemView.findViewById<TextView>(R.id.item_name)
        val nf_calories = itemView.findViewById<TextView>(R.id.item_kcal)
        val nf_total_fat = itemView.findViewById<TextView>(R.id.item_fat)
        val nf_protein = itemView.findViewById<TextView>(R.id.item_protein)
        val nf_total_carbohydrate = itemView.findViewById<TextView>(R.id.item_carbo)
        val buttonAddProduct = itemView.findViewById<Button>(R.id.add_item)
    }

    override fun getItemCount(): Int {
        return if (products == null) 0 else 10
    }
}