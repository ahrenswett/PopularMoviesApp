package com.ninety8point6.moviequest.ui.composables


import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.os.bundleOf
import com.ninety8point6.moviequest.BuyMovieActivity
import com.ninety8point6.moviequest.R
import com.ninety8point6.moviequest.data.Movie
import com.ninety8point6.moviequest.movieSource
import com.ninety8point6.moviequest.ui.composables.movieList.GetMoviePoster
import com.ninety8point6.moviequest.ui.composables.movieList.MovieList
import kotlinx.coroutines.runBlocking
import org.intellij.lang.annotations.JdkConstants
import androidx.compose.material.Text as Text


@Composable
fun App(){
    var movieList by remember{ mutableStateOf(movieSource.popularMovieResultsList)}
      MovieList(movieList = movieList)
}


@Composable
fun BuyMovie(movieIndex: Int, onContinueClicked: () -> Unit){
    val context = LocalContext.current
    val movie = movieSource.popularMovieResultsList[movieIndex]
    val title = movie.title
    val poster = movie.poster_path
    val  overview = movie.overview

   Column(modifier= Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ) {
//           GetMoviePoster(movieTitle = title, moviePoster = poster, "original")
       Row(modifier = Modifier.fillMaxWidth()) {
           GetMoviePoster(movieTitle = title, moviePoster = poster, "original")
       }
//       Reload with search results
       Button(onClick = onContinueClicked
       ){
            Text(text = "Buy Movie!")
       }
   }
    Surface(modifier = Modifier
        .alpha(alpha = 0.5f)
        .background(Color.Red))  {
        Column() {
            Text(text = overview,)
        }
    }
}



