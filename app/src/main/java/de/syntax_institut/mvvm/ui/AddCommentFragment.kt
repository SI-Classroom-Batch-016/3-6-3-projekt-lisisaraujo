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

class AddCommentFragment : Fragment() {
    private lateinit var binding: FragmentAddCommentBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCommentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var location = viewModel.currentLocation.value?.name.toString()
        var age: String = ""
        var sexualOrientation: String = ""
        var gender: String = ""
        var isBipoc: Boolean = false

        val ageAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf("Select", "<18", "19 - 25", "26-35", "36 - 45", "46 - 55", "55+")
        )
        ageAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.ageSpinner.setAdapter(ageAdapter)

        val genderAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf(
                "Select",
                "Genderfluid",
                "Genderqueer",
                "Transgender male",
                "Transgender female",
                "Nonbinary",
                "Intersex",
                "Cisgender female",
                "Cisgender male",
                "I don't know",
                "Other"
            )
        )
        genderAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.genderSpinner.setAdapter(genderAdapter)

        val sexualOrientationAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf(
                "Select",
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

        val bipocAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf("Select", "Yes", "No")
        )
        bipocAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.isBipocSpinner.setAdapter(bipocAdapter)

        binding.ageSpinner.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                age = s.toString()
            }
        })

        binding.genderSpinner.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                gender = s.toString()
            }
        })

        binding.sexualOrientationSpinner.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                sexualOrientation = s.toString()
            }
        })

        binding.isBipocSpinner.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                isBipoc = s.toString().lowercase() == "yes"
            }
        })

        binding.submitBTN.setOnClickListener {
            val comment = binding.commentET.text.toString()
            val newComment = Comment(
                "", location, comment, age, sexualOrientation, gender, isBipoc
            )

            viewModel.addComment(
                newComment
            )
            it.findNavController().navigateUp()
            Log.d("AddedComment", viewModel.commentsList.value?.last()!!.comment)
            Log.d("CommentsList", viewModel.commentsList.value.toString())
        }
    }
}