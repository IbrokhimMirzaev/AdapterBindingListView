package com.example.adapterbindinglistview

import android.app.SharedElementCallback
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import coil.load
import com.example.adapterbindinglistview.databinding.FragmentDetailBinding
import com.example.adapterbindinglistview.model.country.Country

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        val country = arguments?.getSerializable("country") as Country

//        val animation = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
//        sharedElementEnterTransition = animation
//        sharedElementReturnTransition = animation

        binding.img.load(country.imgUrl) {
            placeholder(R.drawable.empty)
        }

        binding.nameText.text = country.countryName
        binding.areaText.text = "Area: ${country.area}"
        binding.popText.text = "Population: ${country.population}"
        binding.infoText.text = country.info

        return binding.root
    }
}