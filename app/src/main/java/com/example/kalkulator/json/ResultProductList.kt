package com.example.kalkulatorkalorii.json

import com.google.gson.annotations.SerializedName

class ResultProductList {
    @field:SerializedName("Results") var listItems: List<ResultProduct?>? = null
}