package com.example.kalkulator.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.R
import com.example.kalkulator.adapter.SearchingListAdapter
import com.example.kalkulatorkalorii.json.ResultProduct
import kotlinx.android.synthetic.main.fragment_kcal.*

class ProductSearchFragment : Fragment() {

    private lateinit var productSearchViewModel: ProductSearchViewModel
    private lateinit var adapter : SearchingListAdapter

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        
        productSearchViewModel = ProductSearchViewModel()

        var view = inflater.inflate(R.layout.fragment_kcal,container,false)
        return view
    }

    override fun onStart() {
        super.onStart()
        button_search_item.setOnClickListener{
            if (name_product_search?.text.toString() == "") {
                Toast.makeText(requireContext(), "No fill textbox!", Toast.LENGTH_SHORT).show()
            } else {
                val response = productSearchViewModel.getDataFromAPI(name_product_search?.text.toString())
                adapter = SearchingListAdapter(
                    response.listItems,
                    requireContext(),this)
                search_list.adapter = adapter
                search_list.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

//                var list = mutableListOf<ResultProduct>()
//                val product1 = ResultProduct("1", 100.toDouble(), 10.toDouble(), 10.toDouble(),10.toDouble())
//                val product2 = ResultProduct("2", 200.toDouble(), 20.toDouble(), 20.toDouble(),20.toDouble())
//                list.add(product1)
//                list.add(product2)
//
//                adapter = SearchingListAdapter(
//                    list,
//                    requireContext(),this
//                )
//                search_list.adapter = adapter
//                search_list.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)



            }
        }


    }
}