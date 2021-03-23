package com.example.parayo.api

import com.example.parayo.api.response.ApiResponse
import retrofit2.http.GET

interface ParayoApi {
    companion object {
        val instance = ApiGenerator().generate(ParayoApi::class.java)
    }

    @GET("/api/v1/hello")
    suspend fun hello(): ApiResponse<String>
}