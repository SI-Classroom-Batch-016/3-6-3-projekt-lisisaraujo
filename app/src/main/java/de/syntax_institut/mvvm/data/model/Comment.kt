package de.syntax_institut.mvvm.data.model

data class Comment(
    var date: String,
    var location: String,
    var comment: String,
    var age: String,
    var sexualOrientation: String,
    var gender: String,
    var isBipoc: Boolean,
    var name: String = ""

)
