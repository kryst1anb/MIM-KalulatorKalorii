package com.example.kalkulator.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 2, exportSchema = false)
abstract class ProductDB : RoomDatabase() {
    abstract fun productDAO(): ProductDBDAO

    companion object{
        @Volatile
        private var INSTANCE: ProductDB? = null

        fun getInstance(context: Context) : ProductDB{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,ProductDB::class.java,"products_history_db").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}