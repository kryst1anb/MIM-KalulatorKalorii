package com.example.kalkulator.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.R

class FragmentContainerSearch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container_search)

        val fragmentMainList = ProductSearchFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerSearch,fragmentMainList).commit()
        getWindow().setBackgroundDrawableResource(R.drawable.bcg1);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_kalorie -> openFragmentContainerSearch()
            R.id.action_products -> openFragmentContainerList()
            R.id.action_bmr -> openBMR()
            R.id.action_bmi -> openBMI()
            R.id.action_zapotrzebowanie -> openDemand()
        }

        return super.onOptionsItemSelected(item)
    }

    fun openFragmentContainerSearch()
    {
        val intent = Intent(this, FragmentContainerSearch::class.java)
        startActivity(intent)
    }

    fun openFragmentContainerList()
    {
        val intent = Intent(this, FragmentContainerList::class.java)
        startActivity(intent)
    }

    fun openBMR()
    {
        val intent = Intent(this, BMR::class.java)
        startActivity(intent)
    }

    fun openBMI()
    {
        val intent = Intent(this, BMI::class.java)
        startActivity(intent)
    }

    fun openDemand()
    {
        val intent = Intent(this, Demand::class.java)
        startActivity(intent)
    }


}