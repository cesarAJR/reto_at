package com.cesar.data.local.model

import BetDetail
import BetSelection
import com.google.gson.annotations.SerializedName

data class BetDetailResponse(
    @SerializedName("BetNivel")
    val betLevel:String,
    @SerializedName("BetStarts")
    val betStarts:Int,
    @SerializedName("BetStatusName")
    val betStatusName:String,
    @SerializedName("BetTypeName")
    val betTypeName:String,
    @SerializedName("BgSrc")
    val bgSrc:String,
    @SerializedName("CashoutOdds")
    val cashOutOdds:String,
    @SerializedName("TotalOdds")
    val totalOdds:String,
    @SerializedName("TotalStake")
    val totalStake:String,
    @SerializedName("TotalWin")
    val totalWin:String,
    @SerializedName("CashoutValue")
    val cashOutValue:String,
    @SerializedName("CreatedDate")
    val createdDate:String,
    @SerializedName("BetSelections")
    val betSelections:List<BetSelectionResponse>? = null,
    @SerializedName("BetStatus")
    val betStatus:Int,
    @SerializedName("BetType")
    val betType:Int,
    @SerializedName("BetId")
    val betId:Number
)

data class BetSelectionResponse(
    @SerializedName("SelectionId")
    val selectionId:Int,
    @SerializedName("SelectionStatus")
    val selectionStatus:Int,
    @SerializedName("Price")
    val price:String,
    @SerializedName("Name")
    val name:String,
    @SerializedName("Spec")
    val spec:String,
    @SerializedName("MarketTypeId")
    val marketTypeId:Int,
    @SerializedName("MarketId")
    val marketId:Number?=null,
    @SerializedName("MarketName")
    val marketName:String,
    @SerializedName("IsLive")
    val isLive:Boolean,
    @SerializedName("IsBetBuilder")
    val isBetBuilder:Boolean,
    @SerializedName("IsBanker")
    val isBanker:Boolean,
    @SerializedName("IsVirtual")
    val isVirtual:Boolean,
    @SerializedName("EventId")
    val eventId:Int,
    @SerializedName("FeedEventId")
    val feedEventId:Int,
    @SerializedName("EventName")
    val eventName:String,
    @SerializedName("SportTypeId")
    val sportTypeId:Int,
    @SerializedName("CategoryId")
    val categoryId:Int,
    @SerializedName("ChampId")
    val champId:Int,
    @SerializedName("EventDate")
    val eventDate:String,
    @SerializedName("RC")
    val rC:Boolean,
    @SerializedName("IsLiveOrVirtual")
    val isLiveOrVirtual:Boolean,
    @SerializedName("EarlyPayout")
    val earlyPayout:Boolean,
    @SerializedName("BoreDraw")
    val boreDraw:Boolean,
    @SerializedName("DbId")
    val dbId:Int,
    @SerializedName("EventScore")
    val eventScore:String

    )


fun List<BetDetailResponse>.toListBetDetail() : List<BetDetail> = map {
    BetDetail(
        betLevel = it.betLevel,
        betStarts = it.betStarts,
        betStatusName = it.betStatusName,
        betTypeName  = it.betTypeName,
        bgSrc  = it.bgSrc,
        cashOutOdds  = it.cashOutOdds,
        totalOdds  = it.totalOdds,
        totalStake  = it.totalStake,
        totalWin  = it.totalWin,
        cashOutValue  = it.cashOutValue,
        createdDate  = it.createdDate,
        betSelections  = it.betSelections?.toListBetSelection(),
        betStatus = it.betStatus,
        betType = it.betType,
        betId = it.betId,
    )
}

fun List<BetSelectionResponse>.toListBetSelection() : List<BetSelection> = map {
    BetSelection(
        selectionId = it.selectionId,
        selectionStatus = it.selectionStatus,
        price = it.price,
        name  = it.name,
        spec  = it.spec,
        marketTypeId  = it.marketTypeId,
        marketName  = it.marketName,
        isLive  = it.isLive,
        isBetBuilder  = it.isBetBuilder,
        isBanker  = it.isBanker,
        isVirtual  = it.isVirtual,
        eventId  = it.eventId,
        feedEventId  = it.feedEventId,
        eventName  = it.eventName,
        sportTypeId  = it.sportTypeId,
        categoryId  = it.categoryId,
        champId  = it.champId,
        eventDate  = it.eventDate,
        rC  = it.rC,
        isLiveOrVirtual  = it.isLiveOrVirtual,
        earlyPayout  = it.earlyPayout,
        boreDraw  = it.boreDraw,
        dbId  = it.dbId,
        eventScore  = it.eventScore,

    )
}
