package com.cesar.data.datasource.local.login

import android.content.Context
import com.cesar.data.util.readJSONFromAsset
import com.cesar.domain.model.User
import com.google.gson.Gson

class LoginLocalDataSource(private val context: Context) : ILoginLocalDataSource{

    override fun login(): User = Gson().fromJson(readJSONFromAsset(context,"user.json"), User::class.java)

}