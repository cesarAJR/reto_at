package com.cesar.data.datasource.local.history

import com.cesar.data.local.model.BetDetailResponse
import com.cesar.data.local.model.BetResponse

interface IHistoryLocalDataSource {

    fun getHistory(): List<BetResponse>

    fun getDetailHistory(): List<BetDetailResponse>

}