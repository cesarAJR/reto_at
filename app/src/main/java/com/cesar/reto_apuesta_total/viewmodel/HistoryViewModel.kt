package com.cesar.reto_apuesta_total.viewmodel

import BetDetail
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesar.domain.model.Bet
import com.cesar.domain.useCase.detailHistoryUseCase.IDetailHistoryUseCase
import com.cesar.domain.useCase.historyUseCase.IHistoryUseCase
import com.cesar.domain.useCase.searchHistoryUseCase.ISearchHistoryUseCase
import com.cesar.reto_apuesta_total.presentation.history.HistoryElements
import com.cesar.reto_apuesta_total.presentation.history.HistoryUiState
import com.cesar.reto_apuesta_total.presentation.login.LoginUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val useCase: IHistoryUseCase,
    private val detailUseCase: IDetailHistoryUseCase,
    private val searchHistoryUseCase: ISearchHistoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HistoryUiState>(HistoryUiState.Nothing)
    val uiState: StateFlow<HistoryUiState> = _uiState

    var stateElements by mutableStateOf(HistoryElements())

    fun updateList(list : List<Bet>){
        stateElements = stateElements.copy(list = list)
    }

    fun updateDetail(detail : BetDetail,bet:Bet){
        stateElements = stateElements.copy(detail = detail,bet=bet)
    }

    fun changeSearch(search : String){
        stateElements = stateElements.copy(search = search)
    }
    fun changeSelectType(type: String){
        stateElements = stateElements.copy(selectType = type)
    }
    fun changeSelectStatus(status : String){
        stateElements = stateElements.copy(selectStatus = status)
    }

    fun getHistory(){
        viewModelScope.launch {
            viewModelScope.launch(Dispatchers.IO) {
                useCase.execute()
                    .collect{r->
                        if (r.message!=null) _uiState.value = HistoryUiState.Error(r.message!!)
                        else _uiState.value = HistoryUiState.Success(r.data)
                    }
            }
        }
    }

    fun getDetailHistory(bet:Bet){
        viewModelScope.launch {
            viewModelScope.launch(Dispatchers.IO) {
                detailUseCase.execute(bet.game)
                    .collect{r->
                        if (r.message!=null) _uiState.value = HistoryUiState.Error(r.message!!)
                        else _uiState.value = HistoryUiState.SuccessDetail(r.data,bet)
                    }
            }
        }
    }

    fun searchHistory(){
        viewModelScope.launch {
            viewModelScope.launch(Dispatchers.IO) {
                searchHistoryUseCase.execute(stateElements.search?:"",stateElements.selectType?:"",stateElements.selectStatus?:"")
                    .collect{r->
                        if (r.message!=null) _uiState.value = HistoryUiState.Error(r.message!!)
                        else _uiState.value = HistoryUiState.SuccessSearchHistory(r.data)
                    }
            }
        }
    }


}