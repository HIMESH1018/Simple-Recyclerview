package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Adapters.CustomAdapter
import com.example.recyclerview.Models.CustomModel
import kotlin.math.log

class MainActivity : AppCompatActivity() {

     lateinit var recyclerView:RecyclerView;
    lateinit var adapter: CustomAdapter
     var historyList:List<CustomModel> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            setUpUI()
    }


    private fun setUpUI(){


        recyclerView = findViewById(R.id.recyclerview)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){

        historyList = custom_trips();
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CustomAdapter(historyList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListner(object:CustomAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val data:CustomModel = historyList[position]
                Log.e("TAG", "onItemClick: "+data.driver_name)

                val i = Intent(this@MainActivity, DetailActivity::class.java)
                i.putExtra("driver",data.driver_name)
                i.putExtra("vehicle",data.vehicle_type)
                startActivity(i)
            }

        })

    }

    private fun custom_trips(): List<CustomModel> {

        historyList = arrayListOf(
            CustomModel("Toyota Camry", "Adam John", "Cole Bay", "Cole Bay Hill", 8.00, 3.5),
            CustomModel("Toyota Vitz", "Sule Abdul", "Cay Bay", "Belair", 8.50, 3.8),
            CustomModel("Toyota CHR", "Peter Parker", "Indigo Bay", "Cole Bay ", 6.00, 2.5),
            CustomModel("Nissan Sunny", "Micheal Jordan", "Cole Bay", "Cul-de-sac", 12.00, 5.5),
            CustomModel("Toyota Hi-Ace", "Husain Azam", "Orient Beach", "Cruise Port", 10.00, 4.5),
            CustomModel("Mitsubishi Lancer", "Adam Jones", "Fort", "Point Blanche", 9.00, 4.0)
        )
        Log.e("TAG", "custom_trips: "+historyList.size)
        return historyList
    }
}