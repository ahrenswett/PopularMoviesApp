package com.ninety8point6.moviequest.data.classes

import com.ninety8point6.moviequest.data.classes.Movie

data class PopularMovieResults(
    val page: Int,
    val results: List<Movie>
)