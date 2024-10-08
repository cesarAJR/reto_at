package com.cesar.data.local.model

import com.cesar.domain.model.Bet
import com.google.gson.annotations.SerializedName

data class BetResponse(
    val db : Int,
    val game:String,
    @SerializedName("created_date")
    val createdDate:String,
    val wager:Int,
    val status:String,
    val type:String,
    val account:String,
    val odds:Double,
    val winning:Int,
)

fun List<BetResponse>.toListBet() : List<Bet> = map {
    Bet(
        db = it.db,
        game = it.game,
        createdDate = it.createdDate,
        status  = it.status,
        type  = it.type,
        account  = it.account,
        wager  = it.wager,
        odds  = it.odds,
        winning  = it.winning,
    )
}