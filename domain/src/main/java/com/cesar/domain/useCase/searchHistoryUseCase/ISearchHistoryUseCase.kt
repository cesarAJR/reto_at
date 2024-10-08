package com.cesar.domain.useCase.searchHistoryUseCase

import com.cesar.domain.model.Bet
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

interface ISearchHistoryUseCase {

    suspend fun execute(search:String,selectType:String,selectStatus:String): Flow<Result<List<Bet>>>

}