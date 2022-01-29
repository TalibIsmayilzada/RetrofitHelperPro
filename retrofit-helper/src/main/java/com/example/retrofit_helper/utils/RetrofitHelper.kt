package com.example.retrofit_helper.utils

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {


    //Retrofit helper
    inline fun <reified T> setupRetrofit(timoutSec: Long, baseUrl: String): T{
        val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(timoutSec, TimeUnit.SECONDS)
            .connectTimeout(timoutSec, TimeUnit.SECONDS)
            .writeTimeout(timoutSec, TimeUnit.SECONDS)
            .addInterceptor(logging)

        val retrofit = Retrofit.Builder().client(okHttpClient.build())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myInterface: T = retrofit.create(T::class.java)

        return myInterface
    }

}