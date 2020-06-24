package com.sai.marvelepoxy.viewmodel.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.repository.DetailRepository
import com.sai.marvelepoxy.view.viewstate.*
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(private val repository: DetailRepository) : ViewModel() {

    private val _posterLiveData: MutableLiveData<DetailViewState<Poster>>
            by lazy { MutableLiveData<DetailViewState<Poster>>() }
    val posterLiveData: LiveData<DetailViewState<Poster>>
        get() = _posterLiveData

    fun fetchMarvelPoster(id: Long) {
        if (_posterLiveData.value is DetailSuccess || _posterLiveData.value is DetailLoading) {
            return
        }

        _posterLiveData.value = DetailLoading
        viewModelScope.launch {
            try {
                val poster = repository.fetchPoster(id)

                if (poster == null) {
                    _posterLiveData.postValue(DetailError("Error fetching marvel poster"))
                    return@launch
                }

                _posterLiveData.postValue(DetailSuccess(poster))
            } catch (e: Exception) {
                _posterLiveData.postValue(DetailError(e.localizedMessage ?: "Error fetching marvel poster"))
            }
        }
    }
}
