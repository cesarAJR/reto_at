package com.cesar.data.di

import android.content.Context
import android.content.SharedPreferences
import com.cesar.data.datasource.local.history.HistoryLocalDataSource
import com.cesar.data.datasource.local.history.IHistoryLocalDataSource
import com.cesar.data.datasource.local.login.ILoginLocalDataSource
import com.cesar.data.datasource.local.login.LoginLocalDataSource
import com.cesar.data.repository.HistoryRepository
import com.cesar.data.repository.LoginRepository
import com.cesar.domain.repository.IHistoryRepository
import com.cesar.domain.repository.ILoginRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { provideSharePreferences(androidContext())  }

    factory<ILoginLocalDataSource> { LoginLocalDataSource(androidContext()) }
    factory<IHistoryLocalDataSource> { HistoryLocalDataSource(androidContext()) }

    factory<ILoginRepository> { LoginRepository(get(),get()) }
    factory<IHistoryRepository> { HistoryRepository(get()) }
}

fun provideSharePreferences(context : Context) : SharedPreferences {
    return context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
}