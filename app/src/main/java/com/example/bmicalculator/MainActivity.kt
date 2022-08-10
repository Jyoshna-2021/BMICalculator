package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private lateinit var age:EditText
    private lateinit var weight:EditText
    private lateinit var height:EditText
    private lateinit var button: Button
    private lateinit var male:CardView
    private lateinit var female:CardView
    private var gender:String="male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weight = findViewById(R.id.Weightinkg)
        height = findViewById(R.id.Heightincm)
        button = findViewById(R.id.btnCalculate)
        age=findViewById(R.id.agenumber)
        male=findViewById(R.id.Male)
        female=findViewById(R.id.Female)
        male.setOnClickListener {
            female.setBackgroundResource(R.drawable.rectangle_outline)
            male.setBackgroundResource(R.drawable.rectangle)
            gender="male"
        }
        female.setOnClickListener {
            female.setBackgroundResource(R.drawable.rectangle)
            male.setBackgroundResource(R.drawable.rectangle_outline)
            gender="Female"
        }

        button.setOnClickListener {
            Log.i("tag", gender)

            val weighttext = weight.text.toString()
            val heighttext = height.text.toString()
            val agetext=age.text.toString()
            if (validateInput(weighttext, heighttext,agetext)) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("WEIGHT", weighttext)
                intent.putExtra("Height", heighttext)
                intent.putExtra("AGE",agetext)
                startActivity(intent)
            }
        }
        }
    private fun validateInput(weighttext: String?, heighttext: String?,agetext:String?): Boolean {
        when {
            weighttext.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_LONG).show()
                return false
            }
            heighttext.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_LONG).show()
                return false
            }
            agetext.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_LONG).show()
                return false
            }
            else -> {
                return true
            }
        }
    }
}


