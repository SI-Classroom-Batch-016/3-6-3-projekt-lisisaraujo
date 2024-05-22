package de.syntax_institut.mvvm.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.annotation.AnnotationConfig
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import de.syntax_institut.mvvm.R
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.data.Repository
import de.syntax_institut.mvvm.data.model.Location
import de.syntax_institut.mvvm.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mapView: MapView
    private var pointAnnotationManager: PointAnnotationManager? = null
    val locations = Repository().locations


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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


        val customStyleJson = "mapbox://styles/laraujo/clv5ohc8f00ky01quh8nqhlre"

        mapView.mapboxMap.loadStyle(customStyleJson) {
            initializeAnnotationManager()
            addLocationMarkers()
        }
    }

    private fun initializeAnnotationManager() {
        val annotationConfig = AnnotationConfig()
        pointAnnotationManager = mapView.annotations.createPointAnnotationManager(annotationConfig)
    }

    private fun addLocationMarkers() {
        locations.forEach { location ->
            val point = Point.fromLngLat(location.longitude, location.latitude)
            val pointAnnotationOptions = bitmapFromDrawableRes(requireContext(), R.drawable.baseline_add_location_24)?.let {
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
}