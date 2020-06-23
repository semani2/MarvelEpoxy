package com.sai.marvelepoxy.data.network

import com.sai.marvelepoxy.data.IDataService
import com.sai.marvelepoxy.model.Poster
import javax.inject.Inject

class NetworkDataService @Inject constructor(private val marvelService: IMarvelService): IDataService {
    
    override suspend fun fetchMarvelPosters() = marvelService.fetchMarvelPosters()

    override suspend fun fetchPosterById(id_: Long): Poster {
        throw NotImplementedError()
    }

    override suspend fun insertPosters(posters: List<Poster>) {
        throw NotImplementedError()
    }
}
