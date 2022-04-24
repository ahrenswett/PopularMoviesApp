package com.ninety8point6.moviequest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ninety8point6.moviequest.ui.composables.BuyMovie
import com.ninety8point6.moviequest.ui.composables.ShowMovie
import com.ninety8point6.moviequest.ui.theme.BuyMovieTheme
import com.ninety8point6.moviequest.ui.theme.GetPopularMoviesTheme


class BuyMovieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BuyMovieTheme() {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    var movieBundle : Bundle? = intent.extras?.getBundle("MOVIE")
                    Log.i("MOVIE_TITLE", "${movieBundle?.get("MOVIE_TITLE")}")
                    ShowMovie(movieBundle!!)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BuyMovieTheme {

    }
}