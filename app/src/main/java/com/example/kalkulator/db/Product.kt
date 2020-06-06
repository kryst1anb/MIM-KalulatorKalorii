package com.example.kalkulator.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products_table")
data class Product (

    @PrimaryKey(autoGenerate = true)
    var id:Int? = 0,
    @ColumnInfo(name="product_name")
    var name: String = "",
    @ColumnInfo(name = "kcal")
    var kcal:Double = 0.0,
    @ColumnInfo(name = "fat")
    var fat:Double = 0.0,
    @ColumnInfo(name = "protein")
    var protein:Double = 0.0,
    @ColumnInfo(name = "carbo")
    var carbo:Double = 0.0
)