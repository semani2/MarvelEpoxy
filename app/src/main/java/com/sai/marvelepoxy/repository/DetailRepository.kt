package com.sai.marvelepoxy.repository

import com.sai.marvelepoxy.data.IDataService
import com.sai.marvelepoxy.di.Persistence
import com.sai.marvelepoxy.model.Poster
import timber.log.Timber
import javax.inject.Inject

class DetailRepository @Inject constructor(@Persistence private val persistenceDataService: IDataService){

    suspend fun fetchPoster(id: Long): Poster? {
        return try {
            return persistenceDataService.fetchPosterById(id)
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }
}
