package com.example.miniprojectce322

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#32CD32")))
        this.title = "BMI";

        ns.setOnClickListener {
            val intent = Intent(this,CalculateBMI::class.java)
            intent.putExtra("user",user.text.toString())
            startActivity(intent)
        }
    }
}