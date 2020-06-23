package com.sai.marvelepoxy.data.persistence

import com.sai.marvelepoxy.data.IDataService
import com.sai.marvelepoxy.model.Poster
import javax.inject.Inject

class PersistenceDataService @Inject constructor(private val posterDao: PosterDao): IDataService {

    override suspend fun fetchMarvelPosters() = posterDao.getPosterList()

    override suspend fun fetchPosterById(id_: Long) = posterDao.getPoster(id_)

    override suspend fun insertPosters(posters: List<Poster>) = posterDao.insertPosterList(posters)
}
