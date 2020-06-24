package com.sai.marvelepoxy.view.viewstate

sealed class DetailViewState<out T>

data class DetailSuccess<out T>(val data: T): DetailViewState<T>()
data class DetailError(val errorMsg: String): DetailViewState<Nothing>()
object DetailLoading: DetailViewState<Nothing>()
