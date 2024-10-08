package com.cesar.domain.model

data class Bet(
    val db : Int,
    val game:String,
    val createdDate:String,
    val status:String,
    val type:String,
    val account:String,
    val wager:Int,
    val odds:Double,
    val winning:Int
)
