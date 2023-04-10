package com.example.adapterbindinglistview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.adapterbindinglistview.R
import com.example.adapterbindinglistview.model.country.Country
import com.example.adapterbindinglistview.utils.ItemTouchAdapter
import java.util.*

class CountryAdapter(var context: Context, var countries: MutableList<Country>, var myInterface: MyInterface) :
    RecyclerView.Adapter<CountryAdapter.MyHolder>(), ItemTouchAdapter {
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
            myInterface.myOnClick(country, holder.img)
        }

        val anim = AnimationUtils.loadAnimation(context, R.anim.item_amin)
        holder.itemView.startAnimation(anim)
    }

    interface MyInterface {
        fun myOnClick(country: Country, img: ImageView)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(countries, i, i + 1)
            }
        } else {
            for (j in fromPosition downTo toPosition + 1) {
                Collections.swap(countries, j, j - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        countries.removeAt(position)
        notifyItemRemoved(position)
    }
}