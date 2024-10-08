package com.cesar.domain.useCase.searchHistoryUseCase

import com.cesar.domain.model.Bet
import com.cesar.domain.repository.IHistoryRepository
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

class SearchHistoryUseCase(private val repository: IHistoryRepository) : ISearchHistoryUseCase {

    override suspend fun execute(search:String,selectType:String,selectStatus:String): Flow<Result<List<Bet>>> {
        return repository.searchHistory(search,selectType,selectStatus)
    }

}