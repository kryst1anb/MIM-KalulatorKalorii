package com.example.kalkulator.ui

import androidx.lifecycle.ViewModel
import com.example.kalkulator.api.apiConnect
import com.example.kalkulatorkalorii.json.ResultProductList

class ProductSearchViewModel : ViewModel() {

    //private var searchedList = ResultProductList().listItems

       fun getDataFromAPI(typedSearch: String): ResultProductList {

           val dataFromApi = apiConnect().apiConnection(typedSearch)

       return dataFromApi
    }
}