package com.sai.marvelepoxy.repository

import com.sai.marvelepoxy.data.IDataService
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.data.network.IMarvelService
import com.sai.marvelepoxy.data.network.NetworkDataService
import com.sai.marvelepoxy.data.persistence.PersistenceDataService
import com.sai.marvelepoxy.data.persistence.PosterDao
import com.sai.marvelepoxy.di.Network
import com.sai.marvelepoxy.di.Persistence
import javax.inject.Inject

class MainRepository @Inject constructor(@Network private val networkDataService: IDataService,
                                         @Persistence private val persistenceDataService: IDataService) {

    suspend fun fetchMarvelPosters(): List<Poster> {
        return networkDataService.fetchMarvelPosters()
    }
}
