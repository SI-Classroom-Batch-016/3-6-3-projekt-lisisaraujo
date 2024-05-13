package de.syntax_institut.mvvm.data.model

data class Location(
    var name: String,
    var address: String,
    var lngLat: List<Double>,
    var type: String,
    var city: String,
//    var postcode: String,
    var comments: MutableList<Comment>
)