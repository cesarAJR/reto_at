package com.cesar.reto_apuesta_total.presentation.login

import com.cesar.domain.model.ResultLogin

sealed class LoginUiState {

    data class Success(val message: String?): LoginUiState()
    data class Error(val message: ResultLogin): LoginUiState()
    data object Loading: LoginUiState()
    data object Nothing: LoginUiState()

}