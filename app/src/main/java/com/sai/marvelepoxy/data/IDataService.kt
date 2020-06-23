package com.sai.marvelepoxy.data

import com.sai.marvelepoxy.model.Poster

interface IDataService {

    suspend fun fetchMarvelPosters(): List<Poster>

    suspend fun fetchPosterById(id_: Long): Poster

    suspend fun insertPosters(posters: List<Poster>)
}
