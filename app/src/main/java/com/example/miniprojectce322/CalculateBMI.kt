package com.example.miniprojectce322

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.miniprojectce322.databinding.ActivityCalculateBmiBinding
import kotlinx.android.synthetic.main.activity_calculate_bmi.*


class CalculateBMI : AppCompatActivity() {

    private lateinit var binding: ActivityCalculateBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val user = intent.getStringExtra("user")
        super.onCreate(savedInstanceState)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#32CD32")))
        this.title = "BMIAPP";
        binding = ActivityCalculateBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Next.setOnClickListener {
            val intent = Intent(this,calculate_water::class.java)
            intent.putExtra("weight",binding.weightPicker.value)
            intent.putExtra("height",binding.heightPicker.value)
            intent.putExtra("user",user)
            startActivity(intent)
        }
        binding.weightPicker.minValue = 25
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 50
        binding.heightPicker.maxValue = 220


        binding.weightPicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }
        binding.heightPicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }
    }
    private fun calculateBMI() {
        val height = binding.heightPicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightPicker.value
        val BMI = weight.toDouble() / (doubleHeight * doubleHeight)
        val user = intent.getStringExtra("user")

        binding.resultsTV.text = String.format("$user BMI is : %.2f",BMI)
        binding.healthyTV.text = String.format("Considered : %S",healthyMs(BMI))

    }
    private fun healthyMs(BMI: Double):String {

        if (BMI < 18.5)
            return "น้ำหนักน้อยกว่าเกณฑ์"
        if (BMI < 25.5)
            return "น้ำหนักสมส่วน"
        if (BMI < 30.0)
            return "น้ำหนักมากกว่าเกณฑ์"
        return "อ้วนมากกกก"
    }
}