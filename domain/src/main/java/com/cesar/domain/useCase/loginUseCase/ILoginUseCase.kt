package com.cesar.domain.useCase.loginUseCase

import com.cesar.domain.model.ResultLogin
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

interface ILoginUseCase {
    suspend fun execute(email:String, password:String): Flow<Result<ResultLogin>>
}