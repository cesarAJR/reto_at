package com.cesar.domain.useCase.historyUseCase

import com.cesar.domain.model.Bet
import com.cesar.domain.model.ResultLogin
import com.cesar.domain.repository.IHistoryRepository
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

class HistoryUseCase(private val repository: IHistoryRepository) : IHistoryUseCase {

    override suspend fun execute(): Flow<Result<List<Bet>>> {
        return repository.getHistory()
    }

}