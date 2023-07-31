package com.example.demohilt.repo

import com.example.demohilt.api.ApiHelperImpl
import com.example.demohilt.data.NetworkClass
import com.example.demohilt.data.PassengerModel
import com.example.demohilt.data.UserModel
import com.example.demohilt.extra.networkClass
import javax.inject.Inject

class UserRepo @Inject constructor(private val apiHelper: ApiHelperImpl) : IUserRepo {

    override suspend fun loginUser(
        emailOrPassword: String,
        password: String,
        rememberMe: Boolean,
    ): NetworkClass<UserModel> {
        return apiHelper.loginUser(emailOrPassword, password, rememberMe).networkClass()
    }

    override suspend fun sendVarificationCode(emailOrPassword: String): NetworkClass<String> {
        return apiHelper.sendVarificationCode(emailOrPassword).networkClass()
    }

    override suspend fun getPassenger(page: Int, size: Int): NetworkClass<PassengerModel> {
        TODO("Not yet implemented")
    }
}