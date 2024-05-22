package de.syntax_institut.mvvm.data.model

data class Location(
    var name: String,
//    var address: String,
    var latitude: Double,
    var longitude: Double,
    var type: String,
//    var city: String,
//    var postcode: String,
    var comments: MutableList<Comment> = mutableListOf()
)