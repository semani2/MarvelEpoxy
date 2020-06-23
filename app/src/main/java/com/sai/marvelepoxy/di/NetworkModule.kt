package com.sai.marvelepoxy.di

import com.sai.marvelepoxy.data.network.IMarvelService
import com.sai.marvelepoxy.data.network.RequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesMarvelService(): IMarvelService {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/semani2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(IMarvelService::class.java)
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }
}
