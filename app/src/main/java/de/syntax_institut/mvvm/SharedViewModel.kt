package de.syntax_institut.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntax_institut.mvvm.adapter.CommentAdapter
import de.syntax_institut.mvvm.data.Repository
import de.syntax_institut.mvvm.data.model.Comment
import de.syntax_institut.mvvm.data.model.Location

class SharedViewModel : ViewModel() {

    private val repository = Repository()
    private val locations: MutableList<Location> = repository.locations
    private val comments: MutableList<Comment> = repository.comments

    private val _locationList = MutableLiveData<MutableList<Location>>(locations)
    val locationList: LiveData<MutableList<Location>>
        get() = _locationList

    private val _commentsList = MutableLiveData<MutableList<Comment>>(comments)
    val commentsList: LiveData<MutableList<Comment>>
        get() = _commentsList


    private val _currentComment = MutableLiveData<Comment>(comments.first())
    val currentComment: LiveData<Comment>
        get() = _currentComment


    private val _currentLocation = MutableLiveData<Location>(locations.first())
    val currentLocation: LiveData<Location>
        get() = _currentLocation

    fun selectLocation(it: Location) {
        _currentLocation.value = it
    }

    fun addComment(comment: Comment) {
        _commentsList.value?.add(comment)
    }

    private val _filteredComments = MutableLiveData<List<Comment>>()
    val filteredComments: LiveData<List<Comment>>
        get() = _filteredComments

    fun filterByAge(age: String) {
        val filteredCommentsList: MutableList<Comment> = if (age.equals("All")) {
            comments
        } else {
            comments.filter { it.age.equals(age) }.toMutableList()
        }
        _commentsList.value = filteredCommentsList
    }

    fun setMapIcon(location: Location): Int {
        var mapIcon = R.drawable.cruising_icon_pink

        when (location.type) {
            "Bar" -> mapIcon = R.drawable.bar_icon_pink
            "Club" -> mapIcon = R.drawable.club_icon_pink
            "Cruising" -> R.drawable.cruising_icon_pink
            "Community-Center" -> R.drawable.community_icon_pink
        }
        return mapIcon
    }

    fun filterLocationsByType(locationType: String): List<Location> {
        var filteredLocations: MutableList<Location> = mutableListOf()

        for (location in locations) {
            if (location.type == locationType) {
                filteredLocations.add(location)
                _locationList.value = filteredLocations
            }
        }
        return filteredLocations
    }

    fun removeLocationFilters() {
        _locationList.value = locations
    }
    fun filterCommentsByLocation(locationName: String?) {
        val filteredComments = locationName?.let { name ->
            comments.filter { it.location == name }
        } ?: emptyList()
        _filteredComments.value = filteredComments
    }
}