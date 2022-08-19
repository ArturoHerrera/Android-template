package com.arthur.android_template.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(
    //private val repository: Repository
) : ViewModel() {

    private val vmUiState = MutableStateFlow(MyUiState())

    val uiState = vmUiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        vmUiState.value
    )

    fun login() {
        vmUiState.update { it.copy( loading = true ) }
        viewModelScope.launch {

        }
    }
}