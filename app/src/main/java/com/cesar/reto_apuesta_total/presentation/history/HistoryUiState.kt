package com.cesar.reto_apuesta_total.presentation.history

import BetDetail
import com.cesar.domain.model.Bet
import com.cesar.domain.model.ResultLogin
import com.cesar.reto_apuesta_total.presentation.login.LoginUiState

sealed class HistoryUiState {
    data class Success(val list: List<Bet>?): HistoryUiState()
    data class SuccessDetail(val data: BetDetail?,val bet:Bet): HistoryUiState()
    data class SuccessSearchHistory(val list: List<Bet>?): HistoryUiState()
    data class Error(val message: String?): HistoryUiState()
    data object Nothing: HistoryUiState()
}