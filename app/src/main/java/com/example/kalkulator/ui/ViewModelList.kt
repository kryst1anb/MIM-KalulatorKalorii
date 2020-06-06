package com.example.kalkulator.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kalkulator.db.Product
import com.example.kalkulator.db.ProductDB

class ViewModelList(application: Application) : AndroidViewModel(application) {

    private val db: ProductDB = ProductDB.getInstance(application)
    var allProducts: LiveData<List<Product>> = db.productDAO().getAllProducts()

}