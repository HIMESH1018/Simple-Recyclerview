package com.example.recyclerview.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Models.CustomModel
import com.example.recyclerview.R

class CustomAdapter(private val dataSet: List<CustomModel>):RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    private var mlistner: onItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_trip_recycler, parent, false)

        if (v == null) {
            Log.d("TAG", "onCreateViewHolder: not null")
        }

        return CustomViewHolder(v, mlistner!!)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val history: CustomModel = dataSet[position]

        holder.vehicle_name.setText(history.vehicle_type)
        holder.driver_name.setText(history.driver_name)
        holder.s_lcoation.setText(history.start_location)
        holder.end_lcoation.setText(history.end_location)
        holder.price.setText("$"+history.price)
        holder.distance.setText(""+history.distance+"Km")

    }

    override fun getItemCount(): Int {

        return dataSet.size;

    }


    class CustomViewHolder(itemView:View,listener:onItemClickListener):RecyclerView.ViewHolder(itemView){
        val vehicle_name: TextView
        val driver_name:TextView
        val s_lcoation:TextView
        val end_lcoation:TextView
        var price:TextView
        val distance:TextView
        val cardView:CardView
        init {

            vehicle_name = itemView.findViewById(R.id.vehicle_name)
            driver_name = itemView.findViewById(R.id.driver_name)
            s_lcoation = itemView.findViewById(R.id.s_lcoation)
            end_lcoation = itemView.findViewById(R.id.end_lcoation)
            price = itemView.findViewById(R.id.price)
            distance = itemView.findViewById(R.id.distance)
            cardView = itemView.findViewById(R.id.cardView)

            cardView.setOnClickListener(View.OnClickListener {
                if (listener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position)
                    }
                }
            })
        }
    }

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(listner: onItemClickListener) {
        mlistner = listner
    }
}