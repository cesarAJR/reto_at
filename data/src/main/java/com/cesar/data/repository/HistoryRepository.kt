package com.cesar.data.repository

import BetDetail
import com.cesar.data.datasource.local.history.IHistoryLocalDataSource
import com.cesar.data.local.model.toListBet
import com.cesar.data.local.model.toListBetDetail
import com.cesar.data.util.changeLanguageStatus
import com.cesar.data.util.changeLanguageType
import com.cesar.domain.model.Bet
import com.cesar.domain.repository.IHistoryRepository
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoryRepository(private val historyRepository: IHistoryLocalDataSource) : IHistoryRepository {

    override suspend fun getHistory(): Flow<Result<List<Bet>>> = flow{
       emit(Result.Successfull(historyRepository.getHistory().toListBet()))
    }

    override suspend fun getDetailHistory(id:String): Flow<Result<BetDetail>> = flow{
        val listBetDetail = historyRepository.getDetailHistory().toListBetDetail()
        var betDetail: BetDetail?=null
        listBetDetail.forEach {
            if (id == it.betId.toString()){
                betDetail =  it
            }
        }



        emit(Result.Successfull(betDetail))
    }

    override suspend fun searchHistory(text:String,selectType:String,selectStatus:String): Flow<Result<List<Bet>>> = flow{
        val listBetDetail = historyRepository.getDetailHistory().toListBetDetail()
        val betIdList :MutableList<String> = mutableListOf()
        listBetDetail.forEach {it->
            it.betSelections?.forEach {it1->
                if (it1.eventName?.contains(text,true) == true){
                    betIdList.add(it.betId.toString())
                }
            }
        }

        val list = betIdList.distinct()

        val historyList = historyRepository.getHistory().toListBet().filter {
            changeLanguageType(it.type).contains(selectType)
        }.filter {
            changeLanguageStatus(it.status).contains(selectStatus)
        }

        val newHistoryList = historyList.filter {
            it.game in list
        }

        emit(Result.Successfull(newHistoryList))
    }
}