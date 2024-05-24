package de.syntax_institut.mvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
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

        viewModel.currentLocation.observe(viewLifecycleOwner) { currentLocation ->
            binding.locationDetailsCardLocationNameTV.text = currentLocation.name
            binding.locationDetailsCardLocationNameTV.text = currentLocation.name
            binding.locationDetailsLocationTypeTV.text = currentLocation.type
            binding.locationDetailsLocationIconIV.setImageResource(viewModel.setMapIcon(currentLocation))

            // Filter comments by the current location
            viewModel.filterCommentsByLocation(currentLocation.name)
        }

        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.addCommentFAB.setOnClickListener {
            it.findNavController().navigate(R.id.addCommentFragment)
        }

        val recyclerView = binding.commentCardRV
        viewModel.filteredComments.observe(viewLifecycleOwner) { filteredComments ->
            recyclerView.adapter = viewModel.currentLocation.value?.let { currentLocation ->
                CommentAdapter(filteredComments.toMutableList(), currentLocation.name)
            }
        }
    }
}
