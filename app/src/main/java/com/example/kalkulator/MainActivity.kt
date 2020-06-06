package com.example.kalkulator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.kalkulator.ui.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Healthy Lifestyle";
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when (item.itemId) {
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

    fun openDemand(){
        val intent = Intent(this, Demand::class.java)
        startActivity(intent)
    }

}
