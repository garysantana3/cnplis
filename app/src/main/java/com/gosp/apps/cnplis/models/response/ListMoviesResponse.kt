package com.gosp.apps.cnplis.models.response

import com.gosp.apps.cnplis.models.Movie
import com.gosp.apps.cnplis.models.Route

data class ListMoviesResponse(
    val movies: ArrayList<Movie>,
    val routes: ArrayList<Route>
)