package com.sai.marvelepoxy.di

import com.sai.marvelepoxy.data.IDataService
import com.sai.marvelepoxy.data.network.IMarvelService
import com.sai.marvelepoxy.data.network.NetworkDataService
import com.sai.marvelepoxy.data.persistence.PersistenceDataService
import com.sai.marvelepoxy.data.persistence.PosterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Persistence
    @Provides
    fun providePersistenceDataService(
        posterDao: PosterDao
    ): IDataService {
        return PersistenceDataService(posterDao)
    }

    @Network
    @Provides
    fun provideNetworkDataService(
        marvelService: IMarvelService
    ): IDataService {
        return NetworkDataService(marvelService)
    }
}
