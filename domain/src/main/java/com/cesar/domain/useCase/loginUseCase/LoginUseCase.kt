package com.cesar.domain.useCase.loginUseCase

import com.cesar.domain.model.ResultLogin
import com.cesar.domain.repository.ILoginRepository
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

class LoginUseCase(private val repository: ILoginRepository): ILoginUseCase {
    override suspend fun execute(email: String, password: String): Flow<Result<ResultLogin>> {
        return repository.login(email,password)
    }
}