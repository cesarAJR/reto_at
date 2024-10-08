package com.cesar.reto_apuesta_total.presentation.history

import BetDetail
import com.cesar.domain.model.Bet

data class HistoryElements(
    val list : List<Bet>?=null,
    val detail : BetDetail?=null,
    val bet : Bet?=null,
    val search:String?=null,
    val selectType:String?=null,
    val selectStatus:String?=null,

)