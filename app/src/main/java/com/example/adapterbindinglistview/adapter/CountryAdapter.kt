package com.example.adapterbindinglistview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import coil.load
import com.example.adapterbindinglistview.R
import com.example.adapterbindinglistview.databinding.CountryItemBinding
import com.example.adapterbindinglistview.databinding.ListItemBinding
import com.example.adapterbindinglistview.model.country.Country

class CountryAdapter(context: Context, var countries: MutableList<Country>) :
    ArrayAdapter<Country>(context, R.layout.list_item, countries) {

    override fun getCount(): Int {
        return countries.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val countryItem: CountryItemBinding
        if (convertView == null) {
            countryItem = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            Log.d("TAG", "create: $position")
        }
        else {
            countryItem = CountryItemBinding.bind(convertView)
            Log.d("TAG", "update: $position")
        }

        val country = countries[position]

        countryItem.countryName.text = country.countryName
        countryItem.countryArea.text = "Area: ${country.area}"
        countryItem.countryPopulation.text = "Population: ${country.population}"
        countryItem.img.load(country.imgUrl) {
            placeholder(R.drawable.empty)
        }

        return countryItem.root
    }
}