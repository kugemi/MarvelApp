package com.kugemi.marvelapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kugemi.marvelapp.data.SortType
import com.kugemi.marvelapp.infrastructure.repositories.implementation.CharactersRepository
import com.kugemi.marvelapp.model.MarvelResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private val myMarvelResponse = MutableLiveData<MarvelResponse>()

    val marvelResponse: LiveData<MarvelResponse>
        get() = myMarvelResponse

    private val myCurrentCharacter = MutableLiveData<com.kugemi.marvelapp.model.Result>()

    val currentCharacter: LiveData<com.kugemi.marvelapp.model.Result>
        get() = myCurrentCharacter

    private val mySortType = MutableLiveData(SortType.ALPHABET_ASCENDING)

    val sortType: LiveData<SortType>
        get() = mySortType

    init {
        viewModelScope.launch(Dispatchers.IO) {
            charactersRepository.getCharacters()?.let { response ->
                myMarvelResponse.postValue(response)
            }
        }
    }

    fun updateCurrentCharacter(result: com.kugemi.marvelapp.model.Result) {
        myCurrentCharacter.postValue(result)
    }

    fun updateSortType(type: SortType) {
        mySortType.postValue(type)
    }
}