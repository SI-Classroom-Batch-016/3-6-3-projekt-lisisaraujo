package de.syntax_institut.mvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import de.syntax_institut.mvvm.R
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.adapter.CommentAdapter
import de.syntax_institut.mvvm.adapter.LocationAdapter
import de.syntax_institut.mvvm.data.model.Comment
import de.syntax_institut.mvvm.data.model.Location
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

        val comments = viewModel.commentsList.value

        viewModel.currentLocation.observe(viewLifecycleOwner) { currentLocation ->
            binding.locationDetailsLocationNameTV.text = currentLocation.name
//            binding.locationDetailsLocationAddressTV.text = currentLocation.address
            binding.locationDetailsCardLocationNameTV.text = currentLocation.name
            binding.locationDetailsLocationTypeTV.text = currentLocation.type
        }

        binding.locationDetailsBackBTN.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.addCommentFAB.setOnClickListener {
            it.findNavController().navigate(R.id.addCommentFragment)
        }


        val recyclerView = binding.commentCardRV

//        viewModel.commentsList.observe(viewLifecycleOwner) { comments ->
//
//        }

        if (comments != null) {
            val filteredComments = comments.filter { comment ->
                comment.location == viewModel.currentLocation.value?.name
            }.toMutableList()
            recyclerView.adapter =
                viewModel.currentLocation.value?.let { CommentAdapter(filteredComments, it.name) }
        }
    }
}