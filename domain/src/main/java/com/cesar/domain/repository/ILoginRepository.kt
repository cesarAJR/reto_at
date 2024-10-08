package com.cesar.domain.repository

import com.cesar.domain.model.ResultLogin
import com.example.domain.core.Result
import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    suspend fun login(email:String,password:String): Flow<Result<ResultLogin>>
}