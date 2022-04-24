package com.ninety8point6.moviequest.data

import io.ktor.client.*

val MoviesHttpClient : HttpClient by lazy { HttpClient(){ expectSuccess = true }}