package com.sai.marvelepoxy

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MarvelEpoxyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initStetho()
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
