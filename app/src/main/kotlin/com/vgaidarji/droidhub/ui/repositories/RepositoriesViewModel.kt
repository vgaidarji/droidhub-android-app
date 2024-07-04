package com.vgaidarji.droidhub.ui.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RepositoriesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is repositories Fragment"
    }
    val text: LiveData<String> = _text
}
