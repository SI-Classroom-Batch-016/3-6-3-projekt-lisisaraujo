package de.syntax_institut.mvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.data.model.Location
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


        binding.closeBTN.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.addBTN.setOnClickListener {
            val name = binding.locationNameET.text.toString()
            val address = binding.locationAddressET.text.toString()
            val type = binding.locationTypeET.text.toString()

            viewModel.locationList.value?.add(
                Location(
                    name, 0.0, 0.0, type,
                    mutableListOf()
                )
            )
            it.findNavController().navigateUp()
            Log.d("AddedLocation", viewModel.locationList.value?.last()!!.name)
        }
    }
}