package com.sai.marvelepoxy.di

import android.content.Context
import androidx.room.Room
import com.sai.marvelepoxy.persistence.AppDatabase
import com.sai.marvelepoxy.persistence.PosterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PersistenceModule {

    @Singleton
    @Provides
    fun providePosterDao(appDatabase: AppDatabase): PosterDao {
        return appDatabase.posterDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "marvel.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
