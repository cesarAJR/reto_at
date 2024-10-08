package com.cesar.domain.useCase.historyUseCase

import com.cesar.domain.model.Bet
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

interface IHistoryUseCase {
    suspend fun execute(): Flow<Result<List<Bet>>>
}