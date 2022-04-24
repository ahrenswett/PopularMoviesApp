package com.ninety8point6.moviequest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.ninety8point6.moviequest.data.client.MovieSource
import com.ninety8point6.moviequest.ui.composables.movieList.MovieList
import com.ninety8point6.moviequest.ui.theme.GetPopularMoviesTheme

//would rather implement a local repo
val movieSource = MovieSource()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetPopularMoviesTheme {
                Surface(color = MaterialTheme.colors.background){
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){
    if(movieSource.popularMovieResultsList.isEmpty()) InvalidHttpResponse()
    else {
        var movieList by remember { mutableStateOf(movieSource.popularMovieResultsList) }
        MovieList(movieList = movieList)
    }
}

@Composable
fun InvalidHttpResponse(){
    Text("Failed to reach Movie Source")
}