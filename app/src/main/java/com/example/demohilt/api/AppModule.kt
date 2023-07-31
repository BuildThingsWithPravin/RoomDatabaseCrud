package com.example.demohilt.api

import com.example.demohilt.data.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //https://api.instantwebtools.net/v1/passenger?page=8&size=10

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.instantwebtools.net/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Singleton
    @Provides
    fun provideOkHttpClient() = run {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES) // write timeout
            .readTimeout(5, TimeUnit.MINUTES) // read timeout
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(providesOkhttpInterceptor())
//            .addInterceptor(OkHttpProfilerInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Provides
    fun providesOkhttpInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .header("Authorization", "Bearer " + "")
                .addHeader("Accept", "application/json")
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelper): ApiHelperImpl = apiHelper

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    /*@Singleton
    @Provides
    fun provideRetrofit(
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://facility-api-staging.quinable.com/api/v8/login")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }*/

    /* @Provides
     fun provideAuthInterceptorOkHttpClient(
         authInterceptor: AuthInterceptor
     ): OkHttpClient {
         return OkHttpClient.Builder()
             .addInterceptor(authInterceptor)
             .build()
     }

     @OtherInterceptorOkHttpClient
     @Provides
     fun provideOtherInterceptorOkHttpClient(
         otherInterceptor: OtherInterceptor
     ): OkHttpClient {
         return OkHttpClient.Builder()
             .addInterceptor(otherInterceptor)
             .build()
     }*/

}