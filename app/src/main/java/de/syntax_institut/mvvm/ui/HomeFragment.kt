package de.syntax_institut.mvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import de.syntax_institut.mvvm.R
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var mapView: MapView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // Create a map programmatically and set the initial camera
        mapView = MapView(requireContext())
        mapView.mapboxMap.setCamera(
            CameraOptions.Builder()
                .center(Point.fromLngLat(13.4247, 52.5072))
                .pitch(0.0)
                .zoom(11.0)
                .bearing(0.0)
                .build()

        )

        // Add the map view to the activity (you can also add it to other views as a child)
        binding.root.addView(mapView)

        binding.addLocationFAB.setOnClickListener{

            it.findNavController().navigate(R.id.addLocationFragment)
        }

        val customStyleJson = "mapbox://styles/laraujo/clv5ohc8f00ky01quh8nqhlre"
        mapView.mapboxMap.loadStyle(customStyleJson)




//        val recyclerView = binding.locationListRV
//
//        recyclerView.layoutManager = LinearLayoutManager(context)
//
//        recyclerView.setHasFixedSize(true)
//
//        viewModel.locationList.observe(viewLifecycleOwner) {
//            recyclerView.adapter = LocationAdapter(it, viewModel)
//        }
//
//        viewModel.currentLocation.observe(viewLifecycleOwner) {
//
//        }

    }

}