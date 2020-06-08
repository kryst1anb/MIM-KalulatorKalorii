package com.example.kalkulator.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.R
import kotlinx.android.synthetic.main.fragment_demand.*

class Demand:AppCompatActivity() {

    lateinit var option: Spinner
    val options = arrayOf("Brak aktywności fizycznej",
        "Mała aktywność fizyczna (ćwiczenia 1-3 tygodniowo)",
        "Średnia aktyność fizyczna (ćwiczenia 3-5 tygodniowo)",
        "Duża aktywność fizyczna (ćwiczenia codziennie)",
        "Bardzo duża aktywność fizyczna")
    var optionsNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_demand)

        yourDemand_text.text = ""
        demand_result.text = ""
        option = findViewById(R.id.demand_dropdown)
        option.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("nothing selected")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                optionsNumber = options.get(position)
            }
        }

        val btnCalc = findViewById<Button>(R.id.button_calc_demand)

        btnCalc.setOnClickListener()
        {
            calculateDemand()
            weight_demand.text?.clear()
            height_demand.text?.clear()
            age_demand.text?.clear()
            yourDemand_text.text = "Twoje zapotrzebowanie:2"
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
        val intent = Intent(this,FragmentContainerSearch::class.java)
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

    fun openBMI(){
        val intent = Intent(this, BMI::class.java)
        startActivity(intent)
    }

    fun openDemand()
    {
        val intent = Intent(this, Demand::class.java)
        startActivity(intent)
    }


    fun calculateDemand() {
        var demandWeight: Double = 0.0
        var demandw: String = ""
        var demandHeight: Double = 0.0
        var demandh: String = ""
        var demandAge: Int = 0
        var demandRes: Double = 0.0
        var demandResult: Double = 0.0
        var demnad: Double = 1.0

        if(optionsNumber == options[0]) {demnad = 1.0}
        else if (optionsNumber == options[1]) {demnad = 1.2}
        else if (optionsNumber == options[2]) {demnad = 1.4}
        else if (optionsNumber == options[3]) {demnad = 1.6}
        else if (optionsNumber == options[4]) {demnad = 1.8}
        else {demnad = 2.0}

        if (radio_woman_demand.isChecked && weight_demand.text.toString() != "" && height_demand.text.toString() != "" && age_demand.text.toString() != "" ){
            demandw = weight_demand.text.toString()
            demandWeight = demandw.toDouble()
            demandh = height_demand.text.toString()
            demandHeight = demandh.toDouble()
            demandAge = Integer.parseInt(age_demand.text.toString())
            demandRes = (9.99 * demandWeight) + (6.25 * demandHeight) - (4.92 * demandAge) -161
            demandResult = demandRes * demnad
            demand_result.text = "%.0f".format(demandResult).toString() + " kcl"
        }
        else if(radio_man_demand.isChecked && weight_demand.text.toString() != "" && height_demand.text.toString() != "" && age_demand.text.toString() != ""){
            demandw = weight_demand.text.toString()
            demandWeight = demandw.toDouble()
            demandh = height_demand.text.toString()
            demandHeight = demandh.toDouble()
            demandAge = Integer.parseInt(age_demand.text.toString())
            demandRes = (9.99 * demandWeight) + (6.25 * demandHeight) - (4.92 * demandAge) + 5
            demandResult = demandRes * demnad
            demand_result.text = "%.0f".format(demandResult).toString() + " kcl"
        }
        else{
            Toast.makeText(this@Demand,"Proszę uzupełnić wszystkie pola", Toast.LENGTH_SHORT).show()
        }
    }
}