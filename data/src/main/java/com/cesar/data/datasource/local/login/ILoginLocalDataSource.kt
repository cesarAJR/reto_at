package com.cesar.data.datasource.local.login

import com.cesar.domain.model.User

interface ILoginLocalDataSource {

    fun login():User

}