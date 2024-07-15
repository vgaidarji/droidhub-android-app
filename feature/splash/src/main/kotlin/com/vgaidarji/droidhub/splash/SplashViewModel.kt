package com.vgaidarji.droidhub.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// artificial loading time to simulate application initialization process
private const val SPLASH_SCREEN_LOADING_TIME = 1500L

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SplashUiState())
    val uiState: StateFlow<SplashUiState> get() = _uiState

    init {
        viewModelScope.launch {

            delay(SPLASH_SCREEN_LOADING_TIME)
            _uiState.value = _uiState.value.copy(isLoading = false)
        }
    }
}
