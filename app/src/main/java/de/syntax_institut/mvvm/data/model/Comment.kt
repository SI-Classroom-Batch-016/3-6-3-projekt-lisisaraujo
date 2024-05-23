package de.syntax_institut.mvvm.data.model

data class Comment(
    var date: String,
    var location: String,
    var comment: String,
    var age: Int,
    var sexualOrientation: MutableList<String>,
    var gender: MutableList<String>,
    var isBipoc: Boolean,
    var name: String = ""

)
