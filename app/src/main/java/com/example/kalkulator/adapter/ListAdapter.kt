package com.example.kalkulator.adapter

import android.content.Context
import android.os.AsyncTask
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.R
import com.example.kalkulator.db.Product
import com.example.kalkulator.db.ProductDB

class ListAdapter(val products: List<Product>, val context: Context, val fragment: Fragment): RecyclerView.Adapter<ListAdapter.ViewHolder>()
{
    lateinit var product : Product

    inner class DeleteTask (val getIDProduct: Int): AsyncTask<Void, Void, String>()
    {
        override fun doInBackground(vararg params: Void?): String {
            val getIDProduct = getIDProduct
            try {
                val db = ProductDB.getInstance(context)
                product = db.productDAO().getProduct(getIDProduct)
                db.productDAO().deleteProduct(product)
            }catch (e: Exception) {
                Log.e("Error delete", e.localizedMessage!!)
            }
            return "true"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.one_product,parent,false)
        return ViewHolder(v)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = products[position]
        holder.item_name.text = product.name
        holder.nf_calories.text = product.kcal.toString()
        holder.nf_total_fat.text = product.fat.toString()
        holder.nf_protein.text = product.protein.toString()
        holder.nf_total_carbohydrate.text = product.carbo.toString()

        holder.buttonDelProduct.setOnClickListener {
            val deleteAlert = AlertDialog.Builder(context)
            deleteAlert.setTitle("Delete product")
            deleteAlert.setMessage("Are you sure you want to delete this product? ${product.id!!}")

            deleteAlert.setPositiveButton(android.R.string.yes) { _,_ ->
                DeleteTask(product.id!!).execute()
                Toast.makeText(context,"Product deleted", Toast.LENGTH_SHORT).show()
            }

            deleteAlert.setNegativeButton("Cancel") { _, _ -> }

            deleteAlert.show()

        }
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