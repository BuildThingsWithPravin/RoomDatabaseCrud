package com.example.demohilt.api

import com.example.demohilt.data.PassengerModel
import com.example.demohilt.data.UserModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @Field("email_or_mobile") emailOrMobile: String,
        @Field("password") password: String,
        /*@Field("remember_me") rememberMe: Boolean,*/
    ): Response<UserModel>

    @FormUrlEncoded
    @POST("verification_code/send")
    suspend fun sendVarificationCode(
        @Field("mobile") mobile: String,
    ): Response<String>

    @GET("passenger")
    suspend fun getPassenger(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Response<PassengerModel>

}