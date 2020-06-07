package com.example.kalkulatorkalorii.json

import com.example.kalkulator.json.ResultProduct
import com.google.gson.annotations.SerializedName

data class Result (
//    @field:SerializedName("_type") val _type : String? = null,
//    @field:SerializedName("_id") val _id : String? = null,
    @field:SerializedName("item_name") val item_name : String,
    @field:SerializedName("nf_calories") val nf_calories : Double,
    @field:SerializedName("nf_total_fat") val nf_total_fat : Double,
    @field:SerializedName("nf_total_carbohydrate") val nf_total_carbohydrate : Double,
    @field:SerializedName("nf_protein") val nf_protein : Double,
    @field:SerializedName("nf_serving_weight_grams") val nf_serving_weight_grams : Int,
    //@field:SerializedName("results") val results: List<com.example.kalkulator.json.ResultProduct?>? = null,

    @field:SerializedName("Result") val result: List<ResultProduct?>? = null
)