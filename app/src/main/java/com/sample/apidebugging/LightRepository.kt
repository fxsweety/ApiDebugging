package com.sample.apidebugging

import com.google.gson.GsonBuilder
import com.sample.apidebugging.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LightRepository {
    var client: ApiService = webservice

    suspend fun getLightStatus() = client.lightStatus()
}

val webservice by lazy {
    Retrofit.Builder()
        .baseUrl("https://storage.googleapis.com/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build().create(ApiService::class.java)
}