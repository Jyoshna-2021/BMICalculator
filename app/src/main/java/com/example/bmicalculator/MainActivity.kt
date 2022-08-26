package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var gender:String="male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.Male.setOnClickListener {
            binding.Female.setBackgroundResource(R.drawable.rectangle_outline)
            binding.Male.setBackgroundResource(R.drawable.rectangle)
            gender="male"
        }
       binding.Female.setOnClickListener {
            binding.Female.setBackgroundResource(R.drawable.rectangle)
            binding.Male.setBackgroundResource(R.drawable.rectangle_outline)
            gender="Female"
        }

        binding.btnCalculate.setOnClickListener {
            Log.i("tag", gender)

            val weighttext = binding.Weightinkg.text.toString()
            val heighttext = binding.Heightincm.text.toString()
            val agetext=binding.agenumber.text.toString()
            if (inputValidation(weighttext, heighttext,agetext)) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("WEIGHT", weighttext)
                intent.putExtra("Height", heighttext)
                intent.putExtra("AGE",agetext)
                startActivity(intent)
            }
        }
        }
    private fun inputValidation(weighttext: String?, heighttext: String?,agetext:String?): Boolean {
        when {
            heighttext.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_LONG).show()
                return false
            }

            weighttext.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_LONG).show()
                return false
            }

            agetext.isNullOrEmpty() -> {
                Toast.makeText(this, "age is empty", Toast.LENGTH_LONG).show()
                return false
            }
            else -> {
                return true
            }
        }
    }
}


