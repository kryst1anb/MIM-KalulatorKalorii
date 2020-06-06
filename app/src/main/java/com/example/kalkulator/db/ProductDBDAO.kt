package com.example.kalkulator.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDBDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product:Product)

    @Query("SELECT * FROM products_table ORDER BY id DESC")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("SELECT * FROM products_table WHERE id=:id")
    fun getProduct(id:Int) : Product

    @Update
    fun update(product: Product)

    @Delete
    fun deleteProduct(product: Product)

}