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

        var url ="https://nutritionix-api.p.rapidapi.com/v1_1/search/"

        for(i in 0 until tableSearch.size-1)
            url += tableSearch[i] + "%20"
        url += tableSearch[tableSearch.size-1]

        try {

            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .get()
                .addHeader("x-rapidapi-host", "nutritionix-api.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "eaf8568fa2msh6971f27327cd80dp1ed02djsn43b91a66f71f")
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

                    productsList.listItems = data.results
                }
            })
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return productsList
    }
}