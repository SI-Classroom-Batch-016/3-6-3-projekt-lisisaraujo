package de.syntax_institut.mvvm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.mvvm.R
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.data.model.Location
import de.syntax_institut.mvvm.databinding.LocationDetailsBinding

class LocationAdapter(private val locations: List<Location>, private val viewModel: SharedViewModel) :
    RecyclerView.Adapter<LocationAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: LocationDetailsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val binding =
            LocationDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val location = locations[position]
        val binding = holder.binding
        binding.locationDetailsCardLocationNameTV.text = location.name
        binding.locationDetailsLocationTypeTV.text = location.type
        binding.locationDetailsLocationAddressTV.text = location.address

        binding.locationDetailLocationCardCV.setOnClickListener {
            viewModel.goToLocationPage(position)
            it.findNavController().navigate(R.id.locationFragment)
        }
    }
}