package com.cesar.domain.useCase.detailHistoryUseCase

import BetDetail
import com.cesar.domain.model.Bet
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

interface IDetailHistoryUseCase {

    suspend fun execute(id:String): Flow<Result<BetDetail>>

}