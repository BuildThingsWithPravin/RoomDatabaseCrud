package com.example.demohilt.api

import com.example.demohilt.data.PassengerModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) : ApiHelperImpl {

    override suspend fun loginUser(
        emailOrMobile: String,
        password: String,
        rememberMe: Boolean,
    ) = apiService.loginUser(emailOrMobile, password)

    override suspend fun sendVarificationCode(emailOrMobile: String) =
        apiService.sendVarificationCode(emailOrMobile)

    override suspend fun getPassenger(page: Int, size: Int): Response<PassengerModel> =
        apiService.getPassenger(page, size)



}