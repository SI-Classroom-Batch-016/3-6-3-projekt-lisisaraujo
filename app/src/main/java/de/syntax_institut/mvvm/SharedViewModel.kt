package de.syntax_institut.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    fun filterByAge(age: String) {
        val filteredCommentsList: MutableList<Comment> = if (age.equals("All")) {
            comments
        } else {
            comments.filter { it.age.equals(age) }.toMutableList()
        }
        _commentsList.value = filteredCommentsList
    }
}