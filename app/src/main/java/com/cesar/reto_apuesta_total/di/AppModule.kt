package com.cesar.reto_apuesta_total.di

import com.cesar.reto_apuesta_total.presentation.history.HistoryScreen
import com.cesar.reto_apuesta_total.viewmodel.HistoryViewModel
import com.cesar.reto_apuesta_total.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { HistoryViewModel(get(),get(),get()) }
}