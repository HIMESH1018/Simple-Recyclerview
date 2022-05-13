package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    lateinit var driverName:TextView
    lateinit var vehicleName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpUI()
    }


    fun setUpUI(){

        driverName = findViewById(R.id.driver_name);
        vehicleName = findViewById(R.id.vehicle_name)

        getData()
    }

    fun getData(){

        val mIntent = intent
        var driver:String = mIntent.getStringExtra("driver").toString()
        var vehicle:String =mIntent.getStringExtra("vehicle").toString()

        driverName.setText(driver)
        vehicleName.text = vehicle
    }
}