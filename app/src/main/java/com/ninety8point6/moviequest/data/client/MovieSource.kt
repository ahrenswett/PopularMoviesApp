package com.ninety8point6.moviequest.data.client

import android.util.Log
import com.google.gson.GsonBuilder
import com.ninety8point6.moviequest.data.MoviesHttpClient
import com.ninety8point6.moviequest.data.classes.Movie
import com.ninety8point6.moviequest.data.classes.PopularMovieResults
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


class MovieSource(private val client : HttpClient = MoviesHttpClient){
//      Load the movies
    val popularMovieResultsList: List<Movie> = runBlocking {load("https://api.themoviedb.org/3/movie/popular?api_key=8b2abf063dfc9dd2ce0841c68fd7e56c&page=1")}

//    Get the movies via via async coroutine
    suspend fun load(url: String): List<Movie> = withContext(Dispatchers.IO){
        // get the response
        val gson = GsonBuilder().create()
        var response = client.getPopularMovies(url).bodyAsText()
        if (response == ""){
            return@withContext emptyList()
        }
        Log.i("response",response)
        val popularMovieResultsResponse = gson.fromJson(response, PopularMovieResults::class.java)
        // Return the list
        return@withContext popularMovieResultsResponse.results
    }
}

suspend fun HttpClient.getPopularMovies(url : String): HttpResponse = get(url)

