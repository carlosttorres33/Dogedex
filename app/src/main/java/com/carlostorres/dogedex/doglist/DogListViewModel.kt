package com.carlostorres.dogedex.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlostorres.dogedex.data.models.DogListResponse
import com.carlostorres.dogedex.data.models.DogResponse
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {

    private val _dogList = MutableLiveData<List<DogListResponse>>()
    val dogList : LiveData<List<DogListResponse>>
        get() = _dogList

    private val dogRepository = DogRepo()

    init {

        downloadDogs()

    }

    private fun downloadDogs() {
        viewModelScope.launch {
            _dogList.value = dogRepository.downloadDogs()
        }
    }

}