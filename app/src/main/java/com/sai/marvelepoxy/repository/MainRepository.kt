package com.sai.marvelepoxy.repository

import com.sai.marvelepoxy.data.IDataService
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.data.network.IMarvelService
import com.sai.marvelepoxy.data.network.NetworkDataService
import com.sai.marvelepoxy.data.persistence.PersistenceDataService
import com.sai.marvelepoxy.data.persistence.PosterDao
import com.sai.marvelepoxy.di.Network
import com.sai.marvelepoxy.di.Persistence
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(@Network private val networkDataService: IDataService,
                                         @Persistence private val persistenceDataService: IDataService) {

    suspend fun fetchMarvelPosters(): List<Poster>? {
        return try {
            var posters = persistenceDataService.fetchMarvelPosters()
            if (posters.isNullOrEmpty()) {
                posters = networkDataService.fetchMarvelPosters()
                persistenceDataService.insertPosters(posters)
                persistenceDataService.fetchMarvelPosters()
            } else {
                posters
            }
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }
}
