package com.example.kalkulator.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.R
import kotlinx.android.synthetic.main.fragment_bmr.*

class BMR : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_bmr)

        val btnCalc = findViewById<Button>(R.id.button_calc_bmr)

        bmr_result.text=""
        yourBMR_text.text = ""

        btnCalc.setOnClickListener()
        {
            calculateBMR()
            weight_bmr.text?.clear()
            height_bmr.text?.clear()
            age_bmr.text?.clear()
            yourBMR_text.text = "Twoje BMR:"
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
        val intent = Intent(this, FragmentContainerList::class.java)
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

    var bmrWeight: Double = 0.0
    var bmrw: String = ""
    var bmrHeight: Double = 0.0
    var bmrh: String = ""
    var bmrAge: Int = 0
    var bmrResult: Double = 0.0



    fun calculateBMR() {
        if (radio_man_bmr.isChecked && weight_bmr.text.toString() != "" && height_bmr.text.toString() != "" && age_bmr.text.toString() != "") {
            bmrw = weight_bmr.text.toString()
            bmrWeight = bmrw.toDouble()
            bmrh = height_bmr.text.toString()
            bmrHeight = bmrh.toDouble()
            bmrAge = Integer.parseInt(age_bmr.text.toString())
            bmrResult = (9.99 * bmrWeight) + (6.25 * bmrHeight) - (4.92 * bmrAge) + 5
            bmr_result.text = "%.2f".format(bmrResult).toString()
        }
        else if(radio_woman_bmr.isChecked && weight_bmr.text.toString() != "" && height_bmr.text.toString() != "" && age_bmr.text.toString() != "")
        {
            bmrw = weight_bmr.text.toString()
            bmrWeight = bmrw.toDouble()
            bmrh = height_bmr.text.toString()
            bmrHeight = bmrh.toDouble()
            bmrAge = Integer.parseInt(age_bmr.text.toString())
            bmrResult = (9.99 * bmrWeight) + (6.25 * bmrHeight) - (4.92 * bmrAge) -161
            bmr_result.text = "%.2f".format(bmrResult).toString()
        }
        else
        {
            Toast.makeText(this@BMR,"Proszę uzupełnić wszystkie pola", Toast.LENGTH_SHORT).show()
        }
    }
}