package de.syntax_institut.mvvm.ui

import android.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.data.model.Comment
import de.syntax_institut.mvvm.data.model.Location
import de.syntax_institut.mvvm.databinding.FragmentAddCommentBinding
import de.syntax_institut.mvvm.databinding.FragmentAddLocationBinding
import de.syntax_institut.mvvm.databinding.FragmentFilterLocationsBinding

class FilterLocationsFragment : Fragment() {
    private lateinit var binding: FragmentFilterLocationsBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterLocationsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var locationType = viewModel.currentLocation.value?.type.toString()

        val locationTypeAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf("Select", "Bar", "Club", "Community-Center", "Cruising")
        )
        locationTypeAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.filterTypeDropdown.setAdapter(locationTypeAdapter)


        binding.applyFilterButton.setOnClickListener {
            viewModel.filterLocationsByType(
                locationType
            )
            it.findNavController().navigateUp()
        }

        binding.filterTypeDropdown.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                locationType = s.toString()
            }
        })
        binding.removeFiltersButton.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.removeFiltersButton.setOnClickListener{
            viewModel.removeLocationFilters()
            it.findNavController().navigateUp()
        }
    }
}