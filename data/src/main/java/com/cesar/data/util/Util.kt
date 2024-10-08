package com.cesar.data.util

import android.content.Context
import java.io.InputStream



 fun readJSONFromAsset(context: Context,jsonName: String): String? {
    var json: String? = null
    try {
        val  inputStream: InputStream = context.assets.open(jsonName)
        json = inputStream.bufferedReader().use{it.readText()}
    } catch (ex: Exception) {
        ex.printStackTrace()
        return null
    }
    return json
}

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

