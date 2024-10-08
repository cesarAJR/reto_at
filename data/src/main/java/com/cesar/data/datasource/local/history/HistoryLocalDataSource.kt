package com.cesar.data.datasource.local.history

import android.content.Context
import com.cesar.data.local.model.BetDetailResponse
import com.cesar.data.local.model.BetResponse
import com.cesar.data.util.readJSONFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HistoryLocalDataSource(private val context: Context) : IHistoryLocalDataSource  {

    override fun getHistory(): List<BetResponse> {
        val list = object : TypeToken<List<BetResponse>?>() {}.type
       return Gson().fromJson(readJSONFromAsset(context,"betsHistory.json"), list)
    }

    override fun getDetailHistory(): List<BetDetailResponse> {
        val list = object : TypeToken<List<BetDetailResponse>?>() {}.type
        return Gson().fromJson(readJSONFromAsset(context,"betsDetailHistory.json"), list)
    }
}