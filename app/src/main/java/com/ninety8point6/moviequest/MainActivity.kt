package com.ninety8point6.moviequest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import com.ninety8point6.moviequest.data.Movie
import com.ninety8point6.moviequest.data.MovieSource
import com.ninety8point6.moviequest.data.MoviesHttpClient
import com.ninety8point6.moviequest.ui.composables.App
import com.ninety8point6.moviequest.ui.composables.movieList.GetMoviePoster
import com.ninety8point6.moviequest.ui.theme.GetPopularMoviesTheme
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking


val movieSource = MovieSource()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetPopularMoviesTheme {
//                /* TODO() hoist the State if the buy button is pushed*/
                Surface(color = MaterialTheme.colors.background){
                    App()
                }

            }
        }
    }
}

