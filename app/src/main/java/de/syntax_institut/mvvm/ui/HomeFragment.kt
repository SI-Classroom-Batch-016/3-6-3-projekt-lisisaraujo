package de.syntax_institut.mvvm.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.databinding.FragmentHomeBinding

import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.EdgeInsets
import com.mapbox.maps.MapView
import com.mapbox.maps.plugin.viewport.data.FollowPuckViewportStateBearing
import com.mapbox.maps.plugin.viewport.data.FollowPuckViewportStateOptions
import com.mapbox.maps.plugin.viewport.state.FollowPuckViewportState
import com.mapbox.maps.plugin.viewport.viewport


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
        binding.mapView.addView(mapView)

        val viewportPlugin = mapView.viewport

        val followPuckViewportState: FollowPuckViewportState = viewportPlugin.makeFollowPuckViewportState(
            FollowPuckViewportStateOptions.Builder()
                .bearing(FollowPuckViewportStateBearing.Constant(0.0))
                .padding(EdgeInsets(200.0 * resources.displayMetrics.density, 0.0, 0.0, 0.0))
                .build()
        )

        viewportPlugin.transitionTo(followPuckViewportState) { success ->
            // The transition has been completed with a flag indicating whether the transition succeeded
        }
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