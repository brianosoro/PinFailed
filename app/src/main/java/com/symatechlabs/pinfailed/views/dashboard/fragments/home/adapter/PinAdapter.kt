package com.symatechlabs.pinfailed.views.dashboard.fragments.home.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.symatechlabs.pinfailed.R


class PinAdapter (val pinList: List<PinData>, val context: Context): RecyclerView.Adapter<PinAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pin_entry_layout, parent, false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int {

        return pinList.size;
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val pinEntered: TextView = itemView.findViewById(R.id.pinEntered)
        val dateTime: TextView = itemView.findViewById(R.id.dateTime)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = pinList[position]

        holder.pinEntered.text = ItemsViewModel.desc;
        holder.dateTime.text = ItemsViewModel.dateTime;


    }


}