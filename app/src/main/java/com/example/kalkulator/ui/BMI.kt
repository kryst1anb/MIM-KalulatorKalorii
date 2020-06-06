package com.example.kalkulator.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.R
import kotlinx.android.synthetic.main.fragment_bmi.*
import kotlinx.android.synthetic.main.fragment_bmr.bmi_result

class BMI : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_bmi)
        val btnCalc = findViewById<Button>(R.id.button_calc_bmi)

        btnCalc.setOnClickListener()
        {
            calculateBMI()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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

    fun openFragmentContainerSearch() {
        val intent = Intent(this, FragmentContainerList::class.java
        )
        startActivity(intent)
    }

    fun openFragmentContainerList() {
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

    var bmiWeigth: Double = 0.0
    var bmiw: String = ""
    var bmiHeight: Double = 0.0
    var bmih: String = ""
    var bmiResult: Double = 0.0

    fun calculateBMI() {
        if (weight_bmi.text.toString() != "" && height_bmi.text.toString() != "") {
            bmiw = weight_bmi.text.toString()
            bmiWeigth = bmiw.toDouble()
            bmih = height_bmi.text.toString()
            bmiHeight = bmih.toDouble()/100
            bmiResult = bmiWeigth/(bmiHeight*bmiHeight)
            bmi_result.text = bmiResult.toString()
            if(bmiResult < 18.5)
                bmi_result_text.text = "Masz niedowagę"
            else if( bmiResult >=18.5 && bmiResult <25)
                bmi_result_text.text = "Waga prawidłowa"
            else if( bmiResult >=25 && bmiResult <30)
                bmi_result_text.text = "Masz nadwagę"
            else if( bmiResult > 30)
                bmi_result_text.text = "Otyłość!"
        }
        else
        {
            Toast.makeText(this@BMI,"Proszę uzupełnić wszystkie pola", Toast.LENGTH_SHORT).show()
        }

    }
}