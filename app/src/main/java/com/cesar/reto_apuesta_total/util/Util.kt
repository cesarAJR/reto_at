package com.cesar.reto_apuesta_total.util

import java.text.SimpleDateFormat
import java.util.Locale

fun changeLanguageStatus(text:String):String{
    return when(text){
        "LOST"->  "Perdido"
        "OPEN"->  "Abierto"
        "WON"->  "Ganado"
        else -> ""
    }
}


fun changeLanguageType(text:String):String{
    return when(text){
        "SIMPLE"->  "Simple"
        "SYSTEM"->  "Sistema"
        else -> ""
    }
}

fun changeFormatDate(date:String):String{
    val dateFormat1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val dateFormat2 = SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.ENGLISH)
    val dateParse = dateFormat1.parse(date)
    return dateFormat2.format(dateParse)
}