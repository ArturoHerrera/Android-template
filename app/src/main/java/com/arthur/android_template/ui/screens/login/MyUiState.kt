package com.arthur.android_template.ui.screens.login

import com.arthur.android_template.data.model.User

data class MyUiState(
    val loading: Boolean = false,
    val loginSuccess: Boolean? = null,
    val user: User? = null
)