package com.sai.marvelepoxy.viewmodel.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.repository.MainRepository
import com.sai.marvelepoxy.view.viewstate.Error
import com.sai.marvelepoxy.view.viewstate.Loading
import com.sai.marvelepoxy.view.viewstate.MainViewState
import com.sai.marvelepoxy.view.viewstate.Success
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel @ViewModelInject constructor(private val repository: MainRepository) : ViewModel() {

    private val _posterLiveData: MutableLiveData<MainViewState<List<Poster>>>
            by lazy { MutableLiveData<MainViewState<List<Poster>>>() }
    val posterLiveData: LiveData<MainViewState<List<Poster>>>
        get() = _posterLiveData

    init {
        fetchMarvelPosters()
    }

    private fun fetchMarvelPosters() {
        if (_posterLiveData.value is Success) {
            return
        }

        _posterLiveData.value = Loading
        viewModelScope.launch {
            try {
                val posters = repository.fetchMarvelPosters()

                if (posters.isNullOrEmpty()) {
                    _posterLiveData.postValue(Error("Error fetching marvel posters"))
                    return@launch
                }

                _posterLiveData.postValue(Success(posters))
            } catch (e: Exception) {
                _posterLiveData.postValue(Error(e.localizedMessage ?: "Error fetching marvel posters"))
            }
        }
    }
}
