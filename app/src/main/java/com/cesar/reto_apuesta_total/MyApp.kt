package com.cesar.reto_apuesta_total

import android.app.Application
import com.cesar.data.di.dataModule
import com.cesar.domain.di.domainModule
import com.cesar.reto_apuesta_total.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules( dataModules+ domainModules+ appModules)
        }
    }

}

val appModules = listOf(appModule)
val domainModules = listOf(domainModule)
val dataModules = listOf(dataModule)