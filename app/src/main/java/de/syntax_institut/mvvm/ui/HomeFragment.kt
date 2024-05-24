package de.syntax_institut.mvvm.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.plugin.annotation.AnnotationConfig
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.OnPointAnnotationClickListener
import com.mapbox.maps.plugin.annotation.generated.PointAnnotation
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import com.mapbox.maps.viewannotation.ViewAnnotationManager
import de.syntax_institut.mvvm.R
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.data.model.Location
import de.syntax_institut.mvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mapView: MapView
    private var pointAnnotationManager: PointAnnotationManager? = null
    private var viewAnnotationManager: ViewAnnotationManager? = null
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMapView()
        setupListeners()
        observeLocationList()

    }

    private fun setupMapView() {
        mapView = MapView(requireContext()).apply {
            mapboxMap.setCamera(
                CameraOptions.Builder()
                    .center(Point.fromLngLat(13.4247, 52.5072))
                    .pitch(0.0)
                    .zoom(12.0)
                    .bearing(0.0)
                    .build()
            )
            binding.root.addView(this)
            mapboxMap.loadStyle("mapbox://styles/laraujo/clwjaz9ai00tb01qr25vu79fo") {
                initializeAnnotationManager()
                observeLocationList()
            }
        }
    }

    private fun setupListeners() {
        binding.addLocationFAB.setOnClickListener {
            findNavController().navigate(R.id.addLocationFragment)
        }

        binding.filterButton.setOnClickListener {
            it.findNavController().navigate(R.id.filterLocationsFragment)
        }
    }

    private fun initializeAnnotationManager() {
        val annotationConfig = AnnotationConfig(layerId = "location-layer")
        pointAnnotationManager = mapView.annotations.createPointAnnotationManager(annotationConfig)
        viewAnnotationManager = mapView.viewAnnotationManager

        pointAnnotationManager?.addClickListener(OnPointAnnotationClickListener { annotation ->
            onPointAnnotationClick(annotation)
            true
        })
    }

    private fun onPointAnnotationClick(annotation: PointAnnotation) {
        val location = viewModel.locationList.value?.find {
            it.latitude == annotation.point.latitude() && it.longitude == annotation.point.longitude()
        }

        location?.let {
            Log.d("clickedLocation", location.name)
            viewModel.selectLocation(it)
            findNavController().navigate(R.id.locationFragment)
        }
    }

    private fun addLocationMarkers(locations: List<Location>) {
        locations.forEach { location ->
            val point = Point.fromLngLat(location.longitude, location.latitude)
            val pointAnnotationOptions = bitmapFromDrawableRes(
                requireContext(),
                viewModel.setMapIcon(location)
            )?.let {
                PointAnnotationOptions()
                    .withPoint(point)
                    .withIconImage(it)
                    .withTextField(location.name)
                    .withTextOffset(listOf(0.0, -1.5))
                    .withTextColor("#FFFFFF")
            }

            if (pointAnnotationOptions != null) {
                pointAnnotationManager?.create(pointAnnotationOptions)
            }
        }
    }

    private fun bitmapFromDrawableRes(context: Context, @DrawableRes resourceId: Int): Bitmap? {
        val drawable = AppCompatResources.getDrawable(context, resourceId)
        return if (drawable is BitmapDrawable) {
            drawable.bitmap
        } else {
            val bitmap = Bitmap.createBitmap(
                drawable?.intrinsicWidth ?: 0,
                drawable?.intrinsicHeight ?: 0,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            drawable?.setBounds(0, 0, canvas.width, canvas.height)
            drawable?.draw(canvas)
            bitmap
        }
    }

    private fun observeLocationList() {
        viewModel.locationList.observe(viewLifecycleOwner) { locations ->
            addLocationMarkers(locations)
        }
    }
}
