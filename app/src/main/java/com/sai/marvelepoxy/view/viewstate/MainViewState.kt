package com.sai.marvelepoxy.view.viewstate

sealed class MainViewState<out T>

data class Success<out T>(val data: T): MainViewState<T>()
data class Error(val errorMsg: String): MainViewState<Nothing>()
object Loading: MainViewState<Nothing>()
