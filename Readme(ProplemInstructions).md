**Problem Statement:**

Imagine that you are building an native app for movie enthusiasts to explore the top-rated movies. 
By integrating with movie API, your app should support the following use-cases:

* Users of your app can view the popular movies at a glance, with title, image (Thumbnail)
* Tapping on an item can take you to an Empty Details Page. 
* Users are able to proceed to purchase the movie ticket via a button (the button’s implementation is not required, the button can lead them to a webview)



From a functional and UX perspective, it is entirely up to you.

**Use above template to get started with the project. It has few libraries. Please feel free to change based on your needs.**

**Considerations**

* This challenge should take approximately 2 hours to complete.
* Implement data loading, basic UI, error handling.
* Keep in mind code readability, scalability, and maintainability when making implementation decisions.
* Provide README with justifications and testing strategies.
* Feel free to use 3rd party libraries.




API: 


Retrieval of the Popular movies:

GET: https://api.themoviedb.org/3/movie/popular?api_key=8b2abf063dfc9dd2ce0841c68fd7e56c&page=1

Reference: https://developers.themoviedb.org/3/movies/get-popular-movies

Name
Type
Description
Required
api_key
string
8b2abf063dfc9dd2ce0841c68fd7e56c
yes
page
string
1
No (Default = 1)



Sample Output:

```
{
  "page": 1,
  "results": [
    {
      "poster_path": "/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg",
      "adult": false,
      "overview": "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
      "release_date": "2016-08-03",
      "genre_ids": [
        14,
        28,
        80
      ],
      "id": 297761,
      "original_title": "Suicide Squad",
      "original_language": "en",
      "title": "Suicide Squad",
      "backdrop_path": "/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg",
      "popularity": 48.261451,
      "vote_count": 1466,
      "video": false,
      "vote_average": 5.91
    },
    …………
  ],
  "total_results": 19629,
  "total_pages": 982
}
```


Retrieval of the Image:


GET: https://image.tmdb.org/t/p/original/eENEf62tMXbhyVvdcXlnQz2wcuT.jpg


Use the “poster_path” property value to retrieve the Image.

