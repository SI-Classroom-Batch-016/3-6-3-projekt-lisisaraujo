package de.syntax_institut.mvvm.ui

import android.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.databinding.FragmentFilterCommentsBinding


class FilterCommentsFragment : Fragment() {
    private lateinit var binding: FragmentFilterCommentsBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterCommentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var age: String = ""
        var sexualOrientation: String = ""
        var gender: String = ""
        var isBipoc: Boolean = false

        val ageAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf("All", "<18", "19-25", "26-35", "36-45", "46-55", "55+")
        )
        ageAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.ageSpinner.setAdapter(ageAdapter)

        binding.ageSpinner.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.filterByAge(s.toString())
            }
        })

        val genderAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf(
                "All",
                "Genderfluid",
                "Genderqueer",
                "Transgender male",
                "Transgender female",
                "Non-binary",
                "Intersex",
                "Cisgender female",
                "Cisgender male",
                "I don't know",
                "Other"
            )
        )
        genderAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.genderSpinner.setAdapter(genderAdapter)

        binding.genderSpinner.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.filterByGender(s.toString().lowercase())
            }
        })

        val sexualOrientationAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf(
                "All",
                "Lesbian",
                "Gay",
                "Pansexual",
                "Bisexual",
                "Asexual",
                "Aromantic",
                "Queer",
                "Demisexual",
                "Heterosexual",
                "Other"
            )
        )
        sexualOrientationAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.sexualOrientationSpinner.setAdapter(sexualOrientationAdapter)

        binding.sexualOrientationSpinner.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.filterBySexualOrientation(s.toString().lowercase())
            }
        })

        val bipocAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf("All", "Yes", "No")
        )

        bipocAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.isBipocSpinner.setAdapter(bipocAdapter)


        binding.isBipocSpinner.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val isBipoc = when (s.toString().lowercase()) {
                    "yes" -> true
                    "no" -> false
                    else -> null
                }

                viewModel.filterByisBipoc(isBipoc)
            }
        })


        binding.applyFilterButton.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.closeButton.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.removeFiltersButton.setOnClickListener {
            viewModel.removeCommentFilters()
           resetFilters()
            it.findNavController().navigateUp()
        }
    }

    private fun resetFilters() {
        binding.ageSpinner.setSelection(0)
        binding.genderSpinner.setSelection(0)
        binding.sexualOrientationSpinner.setSelection(0)
        binding.isBipocSpinner.setSelection(0)
    }
}