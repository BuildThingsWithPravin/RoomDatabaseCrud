package com.example.demohilt.api

import com.example.demohilt.data.PassengerModel
import com.example.demohilt.data.UserModel
import retrofit2.Response

interface ApiHelperImpl {

    suspend fun loginUser(
        emailOrMobile: String,
        password: String,
        rememberMe: Boolean,
    ): Response<UserModel>

    suspend fun sendVarificationCode(
        emailOrMobile: String,
    ): Response<String>

    suspend fun getPassenger(
        page: Int,
        size: Int,
    ): Response<PassengerModel>

}