package com.ninety8point6.moviequest.data.classes


data class Movie(
    val id : Int,
    val title : String,
    val overview : String,
    val poster_path : String,
    var searchURL: String = "",
)
