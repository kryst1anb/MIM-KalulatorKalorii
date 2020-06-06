package com.example.kalkulator.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulator.R
import com.example.kalkulator.adapter.ListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.product_list.*
import java.util.Observer

class FragmentList : Fragment() {

    private lateinit var viewModelList: ViewModelList
    private  lateinit var adapter : ListAdapter

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelList = ViewModelProviders.of(this).get(ViewModelList::class.java)

        val view = inflater.inflate(R.layout.product_list, container, false)


        return view
    }

    override fun onStart() {
        super.onStart()

        viewModelList.allProducts.observe(this, androidx.lifecycle.Observer{
            adapter = ListAdapter(it, requireContext(), this)
            recycler_product_list.adapter = adapter
            recycler_product_list.layoutManager = LinearLayoutManager(activity,RecyclerView.VERTICAL,false)
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()

        recycler_product_list.adapter = null

    }
}