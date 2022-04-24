package com.ninety8point6.moviequest

import androidx.compose.ui.test.junit4.createComposeRule
import com.ninety8point6.moviequest.data.classes.Movie
import com.ninety8point6.moviequest.data.client.MovieSource
import com.ninety8point6.moviequest.ui.composables.movieList.GetMoviePoster
import com.ninety8point6.moviequest.ui.composables.movieList.MovieCard
import com.ninety8point6.moviequest.ui.composables.movieList.MovieList
import org.junit.Rule
import org.junit.Test

class ComposeTest {


@get : Rule
val composeTestRule = createComposeRule()
    private val movieList: List<Movie> = MovieSource().popularMovieResultsList
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun getPosterTest(){
        val movie = movieList[1]
        composeTestRule.setContent {
            //should only show loading wheel in left corner looks like blank screen
            GetMoviePoster(movieTitle =movie.title , moviePoster = movie.poster_path , size = "original" )
        }
        Thread.sleep(5000)
    }


    @Test
    fun movieCardTest() {
        // Start the app
        val movie = movieList[0]
        composeTestRule.setContent {
            MovieCard(movie = movie)
        }
        Thread.sleep(5000)
    }

    @Test
    fun  movieListTest() {
        composeTestRule.setContent {
            MovieList(movieList = movieList)
        }
        Thread.sleep(5000)
    }
}