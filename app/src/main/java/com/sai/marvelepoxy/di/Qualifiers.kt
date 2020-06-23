package com.sai.marvelepoxy.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Network

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Persistence
