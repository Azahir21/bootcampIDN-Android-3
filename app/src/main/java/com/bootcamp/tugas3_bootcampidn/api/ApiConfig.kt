package com.bootcamp.tugas3_bootcampidn.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    val baseUrl = "https://newsapi.org/v2/"

    private fun retrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun service(): ApiService{
        return retrofit().create(ApiService::class.java)
    }
}