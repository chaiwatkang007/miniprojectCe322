package com.example.miniprojectce322

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miniprojectce322.databinding.ActivityCalculateBmiBinding
import kotlinx.android.synthetic.main.activity_calculate_water.*
import kotlinx.android.synthetic.main.activity_main.*


class calculate_water : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_water)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#32CD32")))
        this.title = "BMIAPP";

        val user = intent.getStringExtra("user")
        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        val water = (weight * (2.2 * 30/2))
        name1.text =  (" Name : $user ")
        bmi.text =  ("Height :$height cm. Weight : $weight kg.")
        water1.text =  ("Water per day of $user is : $water ml/d")

        Next.setOnClickListener{
            val intent = Intent(this,CalculateBMI::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }
    }

    }
