package com.ninety8point6.moviequest

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.ninety8point6.moviequest.data.MovieSource
import com.ninety8point6.moviequest.data.MoviesHttpClient
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.ninety8point6.moviequest", appContext.packageName)
    }

    @Test
    fun testHttpRequest() {
        val movieSource = MovieSource()
        assert(movieSource.popularMovieResultsList != null)
    }

    @Test
    fun getTest(){
        var string = ""
        runBlocking { string = MoviesHttpClient.get("https://api.themoviedb.org/3/movie/popular?api_key=8b2abf063dfc9dd2ce0841c68fd7e56c&page=1").bodyAsText()}
        println(string)
    }

}