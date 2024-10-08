package com.cesar.domain.useCase.detailHistoryUseCase

import BetDetail
import com.cesar.domain.repository.IHistoryRepository
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

class DetailHistoryUseCase(private val repository: IHistoryRepository) : IDetailHistoryUseCase {
    override suspend fun execute(id:String): Flow<Result<BetDetail>> {
        return repository.getDetailHistory(id)
    }
}