package com.example.demohilt.repo

import com.example.demohilt.data.NetworkClass
import com.example.demohilt.data.PassengerModel
import com.example.demohilt.data.UserModel

interface IUserRepo {

    suspend fun loginUser(
        emailOrPassword: String,
        password: String,
        rememberMe: Boolean,
    ): NetworkClass<UserModel>

    suspend fun sendVarificationCode(
        emailOrPassword: String,
    ): NetworkClass<String>

    suspend fun getPassenger(
        page: Int,
        size: Int,
    ): NetworkClass<PassengerModel>

}