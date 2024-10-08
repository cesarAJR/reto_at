package com.cesar.domain.repository

import BetDetail
import com.cesar.domain.model.Bet
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface IHistoryRepository {

     suspend fun getHistory(): Flow<Result<List<Bet>>>

     suspend fun getDetailHistory(id:String): Flow<Result<BetDetail>>

     suspend fun searchHistory(text:String,selectType:String,selectStatus:String): Flow<Result<List<Bet>>>
}