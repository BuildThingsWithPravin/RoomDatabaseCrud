package com.example.demohilt.data

import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class HeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .build()
        return chain.proceed(request)
    }
}