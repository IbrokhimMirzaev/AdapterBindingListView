package com.example.adapterbindinglistview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.adapterbindinglistview.R
import com.example.adapterbindinglistview.model.country.Country

class CountryAdapter(var countries: MutableList<Country>, var myInterface: MyInterface) :
    RecyclerView.Adapter<CountryAdapter.MyHolder>() {
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.img)
        val countryName: TextView = itemView.findViewById(R.id.country_name)
        val countryPop: TextView = itemView.findViewById(R.id.country_population)
        val countryArea: TextView = itemView.findViewById(R.id.country_area)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val country = countries[position]
        holder.countryName.text = country.countryName
        holder.countryPop.text = country.population
        holder.countryArea.text = country.area
        holder.img.load(country.imgUrl)

        holder.itemView.setOnClickListener {
            myInterface.myOnClick()
        }
    }

    interface MyInterface {
        fun myOnClick()
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}