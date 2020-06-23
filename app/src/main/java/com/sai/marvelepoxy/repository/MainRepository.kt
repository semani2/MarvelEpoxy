package com.sai.marvelepoxy.repository

import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.network.IMarvelService
import com.sai.marvelepoxy.persistence.PosterDao
import javax.inject.Inject

class MainRepository @Inject constructor(private val marvelService: IMarvelService,
                                         private val posterDao: PosterDao) {

    suspend fun fetchMarvelPosters(): List<Poster> {
        return marvelService.fetchMarvelPosters()
    }
}
