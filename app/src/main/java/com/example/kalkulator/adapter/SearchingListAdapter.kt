package com.example.kalkulator.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.MainActivity
import com.example.kalkulator.R
import com.example.kalkulator.db.Product
import com.example.kalkulator.db.ProductDB
import com.example.kalkulatorkalorii.json.Result
import com.example.kalkulatorkalorii.json.ResultProduct

class SearchingListAdapter(/*val products: List<Result?>?*/val products: List<ResultProduct?>?, val context: Context, val fragment: Fragment) : RecyclerView.Adapter<SearchingListAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.one_item,parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products!![position]!!
        holder.item_name.text = product.item_name
        holder.nf_calories.text = product.nf_calories.toString()
        holder.nf_total_fat.text = product.nf_total_fat.toString()
        holder.nf_protein.text = product.nf_protein.toString()
        holder.nf_total_carbohydrate.text = product.nf_total_carbohydrate.toString()

        /*

        val product = products!![position]!!
        val item_name = product.hits[0].fields.itemName
        val nf_calories = product.hits[0].fields.nfCalories
        val nf_total_fat = product.hits[0].fields.nfTotalFat
        val nf_protein = product.hits[0].fields.nfProtein
        val nf_total_carbohydrate = product.hits[0].fields.nfTotalCarbohydrate
        holder.item_name.text = item_name.toString()
        holder.nf_calories.text =  nf_calories.toString()
        holder.nf_total_fat.text =  nf_total_fat.toString()
        holder.nf_protein.text =  nf_protein.toString()
        holder.nf_total_carbohydrate.text =  nf_total_carbohydrate.toString()

         */

        holder.buttonAddProduct.setOnClickListener {
            Thread {
                val db = ProductDB.getInstance(context)
                val insertProduct = Product(null, product.item_name!!, product.nf_calories!!, product.nf_total_fat!!, product.nf_protein!!, product.nf_total_carbohydrate!!)
                /*val insertProduct = Product(null, item_name!!, nf_calories!!, nf_total_fat!!, nf_protein!!, nf_total_carbohydrate!!)*/
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
        return if (products == null) 0 else products.size
    }
}