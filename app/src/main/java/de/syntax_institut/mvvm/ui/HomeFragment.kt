package de.syntax_institut.mvvm.ui

//import RetrofitInstance
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import de.syntax_institut.mvvm.adapter.LocationAdapter
import de.syntax_institut.mvvm.data.Repository
import de.syntax_institut.mvvm.data.model.Location
import de.syntax_institut.mvvm.databinding.FragmentAddCommentBinding
import de.syntax_institut.mvvm.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mapView: MapView
    private var pointAnnotationManager: PointAnnotationManager? = null
    private var viewAnnotationManager: ViewAnnotationManager? = null
    val locations = Repository().locations
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

        mapView = MapView(requireContext())
        mapView.mapboxMap.setCamera(
            CameraOptions.Builder()
                .center(Point.fromLngLat(13.4247, 52.5072))
                .pitch(0.0)
                .zoom(12.0)
                .bearing(0.0)
                .build()
        )
        binding.root.addView(mapView)

        val customStyleJson = "mapbox://styles/laraujo/clv5ohc8f00ky01quh8nqhlre"

        mapView.mapboxMap.loadStyle(customStyleJson) {
            initializeAnnotationManager()
            addLocationMarkers()
        }

        binding.addLocationFAB.setOnClickListener {
            findNavController().navigate(R.id.addLocationFragment)
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
        val location = locations.find {
            it.latitude == annotation.point.latitude() && it.longitude == annotation.point.longitude()
        }

        location?.let {
            Log.d("clickedLocation", location.name)
            viewModel.selectLocation(it)
            findNavController().navigate(R.id.locationFragment)
        }
    }

    private fun addLocationMarkers() {
        locations.forEach { location ->
            val point = Point.fromLngLat(location.longitude, location.latitude)
            val pointAnnotationOptions = bitmapFromDrawableRes(
                requireContext(),
                R.drawable.baseline_add_location_24
            )?.let {
                PointAnnotationOptions()
                    .withPoint(point)
                    .withIconImage(it)
                    .withTextField(location.name)
                    .withTextOffset(listOf(0.0, -2.5))
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

        // recycler view with locations list

//        val itemClickedCallback: (Location) -> Unit = { location ->
//            viewModel.selectLocation(location)
//
//            findNavController().navigate(R.id.locationFragment)
//        }
//
//        val recyclerView = binding.locationListRV
//
//        viewModel.locationList.observe(viewLifecycleOwner) {
//            recyclerView.adapter = LocationAdapter(it, itemClickedCallback)
//        }
//
//        binding.addLocationFAB.setOnClickListener {
//            it.findNavController().navigate(R.id.addLocationFragment)
//        }
//    }

//    val geocodingPlugin = MapboxGeocoding.builder()
//        .accessToken(YOUR_MAPBOX_ACCESS_TOKEN)
//        .build()

}
