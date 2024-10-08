package com.cesar.data.repository

import android.content.SharedPreferences
import com.cesar.data.datasource.local.login.ILoginLocalDataSource
import com.cesar.domain.model.ResultLogin
import com.cesar.domain.repository.ILoginRepository
import com.example.domain.core.Result
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepository(private val loginLocalDataSource: ILoginLocalDataSource, private val sharedPreferences: SharedPreferences):ILoginRepository {
    override suspend fun login(email: String, password: String): Flow<Result<ResultLogin>> = flow{
           val user = loginLocalDataSource.login()
            if ((user.email.equals(email)|| user.name.equals(email)) && user.password.equals(password)){
                sharedPreferences.edit().putString("USER", Gson().toJson(user)).apply()
                emit(Result.Successfull(ResultLogin("Bienvenido",1)))
            }else{
                var emailUserIncorrect = false
                if (!user.email.equals(email)){
                    emailUserIncorrect = true
                }

                emailUserIncorrect = if (!user.name.equals(email)){
                    true
                }else{
                    false
                }

               if (emailUserIncorrect){
                   emit(Result.Successfull(ResultLogin("Usuario Incorrecto",2)))
               }else{
                   emit(Result.Successfull(ResultLogin("Password Incorrecto",3)))
               }
            }
    }
}