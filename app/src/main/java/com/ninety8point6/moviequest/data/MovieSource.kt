package com.ninety8point6.moviequest.data

import com.google.gson.GsonBuilder
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MovieSource(private val client : HttpClient = MoviesHttpClient){
//      Load the movies
    val popularMovieResultsList: List<Movie> = runBlocking {load()}

//    Get the movies via via async coroutine
    suspend fun load(): List<Movie> = withContext(Dispatchers.IO){
        // get the response
        val gson = GsonBuilder().create()
        val popularMovieResultsResponse = gson.fromJson(client.getPopularMovies()?.bodyAsText(), PopularMovieResults::class.java)

        // Return the list
        return@withContext popularMovieResultsResponse.results
    }
}

suspend fun HttpClient.getPopularMovies(): HttpResponse = get("https://api.themoviedb.org/3/movie/popular?api_key=8b2abf063dfc9dd2ce0841c68fd7e56c&page=1")

