package com.example.kalkulatorkalorii.json

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("total_hits")
    val totalHits: Int,
    @SerializedName("max_score")
    val maxScore: Double,
    val hits: List<Hit>
) {
    data class Hit(
        @SerializedName("_index")
        val index: String,
        @SerializedName("_type")
        val type: String,
        @SerializedName("_id")
        val id: String,
        @SerializedName("_score")
        val score: Double,
        val fields: Fields
    ) {
        data class Fields(
            @SerializedName("item_name")
            val itemName: String? = null,
            @SerializedName("nf_calories")
            val nfCalories: Double,
            @SerializedName("nf_total_fat")
            val nfTotalFat: Double,
            @SerializedName("nf_total_carbohydrate")
            val nfTotalCarbohydrate: Double,
            @SerializedName("nf_protein")
            val nfProtein: Double,
            @SerializedName("nf_serving_size_qty")
            val nfServingSizeQty: Int,
            @SerializedName("nf_serving_size_unit")
            val nfServingSizeUnit: String,
            @SerializedName("nf_serving_weight_grams")
            val nfServingWeightGrams: Int
        )
    }
}