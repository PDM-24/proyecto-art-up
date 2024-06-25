package com.movil.artup

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class Publication(val id: Int, val username: String, val imageRes: Uri, val price: String)

class PublicationsViewModel : ViewModel() {
    private val _publications = MutableStateFlow<List<Publication>>(emptyList())
    val publications: StateFlow<List<Publication>> get() = _publications

    fun addPublication(publication: Publication) {
        viewModelScope.launch {
            _publications.value = _publications.value + publication
        }
    }

    fun getPublicationById(artworkId: Int): Publication? {
        return _publications.value.find { it.id == artworkId }
    }
}
