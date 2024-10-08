package com.cesar.domain.di

import com.cesar.domain.useCase.detailHistoryUseCase.DetailHistoryUseCase
import com.cesar.domain.useCase.detailHistoryUseCase.IDetailHistoryUseCase
import com.cesar.domain.useCase.historyUseCase.HistoryUseCase
import com.cesar.domain.useCase.historyUseCase.IHistoryUseCase
import com.cesar.domain.useCase.loginUseCase.ILoginUseCase
import com.cesar.domain.useCase.loginUseCase.LoginUseCase
import com.cesar.domain.useCase.searchHistoryUseCase.ISearchHistoryUseCase
import com.cesar.domain.useCase.searchHistoryUseCase.SearchHistoryUseCase
import org.koin.dsl.module

val domainModule = module {
    factory <ILoginUseCase>{ LoginUseCase(get())}
    factory <IHistoryUseCase>{ HistoryUseCase(get())}
    factory <IDetailHistoryUseCase>{ DetailHistoryUseCase(get())}
    factory <ISearchHistoryUseCase>{ SearchHistoryUseCase(get())}
}