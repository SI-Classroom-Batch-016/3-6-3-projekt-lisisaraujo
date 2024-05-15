package de.syntax_institut.mvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.databinding.FragmentAddLocationBinding

class AddLocationFragment : Fragment() {
    private lateinit var binding: FragmentAddLocationBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddLocationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val locationName = binding.locationNameET.text
        val locationAddress = binding.locationAddressET.text
        val locationType = binding.locationTypeET.text

        binding.locationNameET.text = locationName
        binding.locationTypeET.text = locationType
        binding.locationAddressET.text = locationAddress

        binding.closeBTN.setOnClickListener{
            it.findNavController().navigateUp()
        }
    }
}