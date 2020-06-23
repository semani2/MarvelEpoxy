package com.sai.marvelepoxy.data.network

import com.sai.marvelepoxy.model.Poster
import retrofit2.http.GET

interface IMarvelService {

    @GET("121cd98135cd5a5b61593c41c2179220/raw/bbb93730cec1d5e0cd72ed44e56959bc62f47ba4/marvel.json")
    suspend fun fetchMarvelPosters(): List<Poster>
}
