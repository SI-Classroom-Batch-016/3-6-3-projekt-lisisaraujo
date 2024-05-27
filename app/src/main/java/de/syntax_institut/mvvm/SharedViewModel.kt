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

    private val _filteredComments = MutableLiveData<List<Comment>>()
    val filteredComments: LiveData<List<Comment>>
        get() = _filteredComments

    fun selectLocation(it: Location) {
        _currentLocation.value = it
    }

    fun addComment(comment: Comment) {
        _commentsList.value?.add(comment)
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

    fun removeCommentFilters() {
        ageFilter = null
        genderFilter = null
        isBipocFilter = null
        sexualOrientationFilter = null
        _commentsList.value = comments
    }

    fun showCommentsInLocation(locationName: String?) {
        val filteredComments = locationName?.let { name ->
            _commentsList.value?.filter { it.location == name }
        } ?: emptyList()
        _filteredComments.value = filteredComments
    }

    private var ageFilter: String? = null
    private var genderFilter: String? = null
    private var isBipocFilter: Boolean? = null
    private var sexualOrientationFilter: String? = null

    fun filterByAge(age: String) {
        ageFilter = if (age == "all") null else age
        applyFilters()
    }

    fun filterByGender(gender: String) {
        genderFilter = if (gender == "all") null else gender
        applyFilters()
    }

    fun filterByisBipoc(isBipoc: Boolean?) {
        isBipocFilter = if (isBipoc == null) null else isBipoc
        applyFilters()
    }

    fun filterBySexualOrientation(sexualOrientation: String) {
        sexualOrientationFilter = if (sexualOrientation == "all") null else sexualOrientation
        applyFilters()
    }
    private fun applyFilters() {
        var filteredComments = comments

        ageFilter?.let { age ->
            filteredComments = filteredComments.filter { it.age == age }.toMutableList()
        }

        genderFilter?.let { gender ->
            filteredComments = filteredComments.filter { it.gender == gender }.toMutableList()
        }

        isBipocFilter?.let { isBipoc ->
            filteredComments = filteredComments.filter { it.isBipoc == isBipoc }.toMutableList()
        }

        sexualOrientationFilter?.let { sexualOrientation ->
            filteredComments = filteredComments.filter { it.sexualOrientation == sexualOrientation }.toMutableList()
        }

        _commentsList.value = filteredComments
    }

}