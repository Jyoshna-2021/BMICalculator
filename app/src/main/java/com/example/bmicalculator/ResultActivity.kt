package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.bmicalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        val getweight = intent.getStringExtra("WEIGHT")
        val getheight = intent.getStringExtra("Height")
        val bmical = getweight!!.toFloat() / ((getheight!!.toFloat() / 100) * (getheight.toFloat() / 100))
            val bmicalculate = String.format("%.2f", bmical).toFloat()
        bmiResult(bmicalculate)
        binding.reBtn.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
        startActivity(intent)}
    }

    private fun bmiResult(bmical: Float) {
        val getage= intent.getStringExtra("AGE")

        val resultIndex = binding.tvIndex
            val resultDescription = binding.tvResult
            val info = binding.tvInfo

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
                bmical > 35.99->{
                    resultText="Extremely Obese"
                    color = R.color.extremelyobese
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