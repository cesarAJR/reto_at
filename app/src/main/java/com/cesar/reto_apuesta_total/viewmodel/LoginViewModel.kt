package com.cesar.reto_apuesta_total.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesar.domain.useCase.loginUseCase.ILoginUseCase
import com.cesar.reto_apuesta_total.presentation.login.LoginElements
import com.cesar.reto_apuesta_total.presentation.login.LoginUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val useCase: ILoginUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Nothing)
    val uiState: StateFlow<LoginUiState> = _uiState

    var stateElements by mutableStateOf(LoginElements())

    fun cleanFields(){
        stateElements= stateElements.copy(email = "", password = "")
    }

    fun changeEmail(email:String){
        stateElements= stateElements.copy(email = email)
    }

    fun changePassword(password:String){
        stateElements= stateElements.copy(password = password)
    }

    fun login(){
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = LoginUiState.Loading
            useCase.execute(stateElements.email,stateElements.password)
                .collect{result->
                    if (result.data?.status!=1) _uiState.value = LoginUiState.Error(result.data!!)
                    else _uiState.value = LoginUiState.Success(result.message)
                }
        }
    }

}