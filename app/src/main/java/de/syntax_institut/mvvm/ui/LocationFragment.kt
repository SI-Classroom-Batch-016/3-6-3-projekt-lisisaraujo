package de.syntax_institut.mvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {
    private lateinit var binding: FragmentLocationBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentLocation.observe(viewLifecycleOwner) { currentLocation ->
            binding.locationDetailsLocationNameTV.text = currentLocation.name
            binding.locationDetailsLocationAddressTV.text = currentLocation.address
            binding.locationDetailsCardLocationNameTV.text = currentLocation.name
            binding.locationDetailsLocationTypeTV.text = currentLocation.type
        }

        binding.locationDetailsBackBTN.setOnClickListener {
            it.findNavController().navigateUp()
        }
    }
}