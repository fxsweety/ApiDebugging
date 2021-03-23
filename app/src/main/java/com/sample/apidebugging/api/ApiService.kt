package com.sample.apidebugging.api

import com.sample.apidebugging.LightStatus
import retrofit2.http.GET

interface ApiService {

    @GET("/myfirebasedemoproject-2c4d0.appspot.com/lightstatus.json")
    suspend fun lightStatus(): LightStatus
}
