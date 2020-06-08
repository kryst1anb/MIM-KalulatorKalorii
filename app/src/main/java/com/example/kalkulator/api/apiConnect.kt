package com.example.kalkulator.api

import android.util.Log
import com.example.kalkulatorkalorii.json.Result
import com.example.kalkulatorkalorii.json.ResultProductList
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class apiConnect {

    companion object {
        private var productsList = ResultProductList()
    }

    fun apiConnection(typedSearch: String): ResultProductList {

        val tableSearch = typedSearch.split(" ".toRegex())
        var url ="https://api.nutritionix.com/v1_1/search/"
        for(i in 0 until tableSearch.size-1)
        {
            url += tableSearch[i] + "%252C"
        }
        url += tableSearch[tableSearch.size-1]
        url += "?fields=brand_name,item_name,item_id,brand_id,nf_calories,nf_total_fat,nf_total_carbohydrate,nf_protein,nf_serving_weight_grams?&appId=b6c40349&appKey=3fdd6f13ef70132033e1102628b62f85"

        try {

            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .get()
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException?) {
                    call.cancel()
                    Log.e("ERROR: ", e.toString())
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call?, response: Response) {
                    val myResponse = response.body()?.string()
                    var gson = GsonBuilder()
                        .setLenient()
                        .create()
                    val data = gson.fromJson(myResponse, Result::class.java)
                    productsList.listItems = data
                }
            })
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return productsList
    }
}