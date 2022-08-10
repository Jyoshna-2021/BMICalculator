package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {
    private lateinit var recalculate:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        recalculate=findViewById(R.id.re_btn)
        val getweight = intent.getStringExtra("WEIGHT")
        val getheight = intent.getStringExtra("Height")
        val bmical = getweight!!.toFloat() / ((getheight!!.toFloat() / 100) * (getheight.toFloat() / 100))
            val bmicalculate = String.format("%.2f", bmical).toFloat()
            displayResult(bmicalculate)
        recalculate.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
        startActivity(intent)}
    }

    private fun displayResult(bmical: Float) {
        val getage= intent.getStringExtra("AGE")

        val resultIndex = findViewById<TextView>(R.id.tvIndex)
            val resultDescription = findViewById<TextView>(R.id.tvResult)
            val info = findViewById<TextView>(R.id.tvInfo)

            resultIndex.text = bmical.toString()
        "(Normal range is 18.5 - 24.9 )".also { info.text = it }
            var resultText = ""
            var color = 0
        if(getage!! >= 20.toString()) {
            when {
                bmical < 18.50 -> {
                    resultText = "Underweight"
                    color = R.color.under_weight
                }
                bmical in 18.50..24.99 -> {
                    resultText = "Healthy"
                    color = R.color.normal
                }
                bmical in 25.00..29.99 -> {
                    resultText = "Overweight"
                    color = R.color.over_weight
                }
                bmical in 30.00..34.99 -> {
                    resultText = "Obese"
                    color = R.color.obese
                }
                bmical>35.99->{
                    resultText="Extremely Obese"
                }
            }
        }
        else{
            when {
                bmical < 5 -> {
                    resultText = "Underweight"
                    color = R.color.under_weight
                }
                bmical in 5.1..84.99 -> {
                    resultText = "Healthy"
                    color = R.color.normal
                }
                bmical in 85.00..90.00 -> {
                    resultText = "Overweight"
                    color = R.color.over_weight
                }
                bmical > 99.00 -> {
                    resultText = "Obese"
                    color = R.color.obese
                }
            }


        }
            resultDescription.setTextColor(ContextCompat.getColor(this, color))
            resultDescription.text = resultText
        }
}