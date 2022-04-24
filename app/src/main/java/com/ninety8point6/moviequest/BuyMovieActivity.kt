package com.ninety8point6.moviequest

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView
import com.ninety8point6.moviequest.ui.composables.BuyMovie
import com.ninety8point6.moviequest.ui.theme.BuyMovieTheme

var movieIdToLookAt = -1

class BuyMovieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Check if coming from the listview or buy view if list save the extra
        if(intent.extras != null) {
            movieIdToLookAt =intent.extras?.get("LIST_INDEX") as Int
        }
        setContent {
            BuyMovieTheme() {
                ShowMovie(movieIdToLookAt)
            }
        }
    }
}


@Composable
fun ShowMovie(movieIndex: Int){
    var goToBuyMovie by remember { mutableStateOf(false) }
    val movie = movieSource.popularMovieResultsList[movieIndex]

    if(!goToBuyMovie) BuyMovie(movieIndex){goToBuyMovie = true}
    else WebViewComp(url = "https://www.google.com/search?q=${movie.title.replace(" ","+")}&")
}

@Composable
fun WebViewComp(url: String){
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {it.loadUrl(url)})
}