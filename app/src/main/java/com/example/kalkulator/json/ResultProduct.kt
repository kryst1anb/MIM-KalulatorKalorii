package com.example.kalkulatorkalorii.json

import com.google.gson.annotations.SerializedName

class ResultProduct (
    @field:SerializedName("item_name") val item_name : String? = null,
    @field:SerializedName("nf_calories") val nf_calories : Double? = null,
    @field:SerializedName("nf_total_fat") val nf_total_fat : Double? = null,
    @field:SerializedName("nf_total_carbohydrate") val nf_total_carbohydrate : Double? = null,
    @field:SerializedName("nf_protein") val nf_protein : Double? = null,
    @field:SerializedName("nf_serving_weight_grams") val nf_serving_weight_grams : Int? = null
)