package com.example.kalkulator.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.kalkulator.api.apiConnect
import com.example.kalkulatorkalorii.json.ResultProductList

class ProductSearchViewModel : ViewModel() {

       fun getDataFromAPI(typedSearch: String): ResultProductList {
           val dataFromApi = apiConnect().apiConnection(typedSearch)

       return dataFromApi
    }
}