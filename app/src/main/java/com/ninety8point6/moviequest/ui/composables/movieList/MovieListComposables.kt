package com.ninety8point6.moviequest.ui.composables.movieList

import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import coil.compose.SubcomposeAsyncImage
import com.ninety8point6.moviequest.BuyMovieActivity
import com.ninety8point6.moviequest.data.Movie


// make a card to hold the movies
@Composable
fun MovieCard(movie: Movie){
    val context = LocalContext.current
    // remember the state of card
    Card(modifier = Modifier.padding(1.dp).fillMaxWidth(),
        elevation = 5.dp,
        backgroundColor =  Color.LightGray,
    ){
        Row(modifier = Modifier.clickable {
            var movieBundle : Bundle = bundleOf(
                "MOVIE_TITLE" to movie.title,
                "OVERVIEW" to movie.overview,
                "POSTER_PATH" to movie.poster_path)
            context.startActivity(Intent(context, BuyMovieActivity::class.java).putExtra("MOVIE",movieBundle))
            }

            ,verticalAlignment = Alignment.CenterVertically) {
            //column for movie picture
            Column() {
                GetMoviePoster(movieTitle = movie.title, moviePoster = movie.poster_path, size = "w200")
            }
            //Vertical spacing between text and thumbnail
            Spacer(modifier = Modifier.width(8.dp))

            //Column for movie title
            Column() {
                Text(text = movie.title, modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.h5)
            }
        }
    }
}




@Composable
// Async call to load the image when prepared as list loads faster
// https://coil-kt.github.io/coil/compose/
fun GetMoviePoster(movieTitle: String, moviePoster : String, size: String) {
    SubcomposeAsyncImage(
        model = "https://image.tmdb.org/t/p/$size/$moviePoster",
        loading = { CircularProgressIndicator() },
        contentDescription = "$movieTitle movie poster",
        modifier = Modifier.padding(5.dp)

    )
}

//make a lazy column to generate cards like a recyclerview
@Composable
fun MovieList(movieList: List<Movie>){
    LazyColumn(Modifier.padding(5.dp)){
        items(movieList){ movie-> MovieCard(movie = movie)}
    }
}
