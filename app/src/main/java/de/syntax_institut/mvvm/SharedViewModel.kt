package de.syntax_institut.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntax_institut.mvvm.data.Repository
import de.syntax_institut.mvvm.data.model.Location

class SharedViewModel : ViewModel() {

    private val repository = Repository()
    private val locations: MutableList<Location> = repository.locations

    private val _locationList = MutableLiveData<MutableList<Location>>(locations)
    val locationList: LiveData<MutableList<Location>>
        get() = _locationList


    private val _currentLocation = MutableLiveData<Location>(locations.first())
    val currentLocation: LiveData<Location>
        get() = _currentLocation

    fun goToLocationPage(position: Int) {
        _currentLocation.value = locations[position]
    }
}