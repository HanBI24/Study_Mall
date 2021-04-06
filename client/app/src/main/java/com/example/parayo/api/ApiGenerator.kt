package com.example.parayo.api

import com.example.parayo.EC2PublicIP
import com.example.parayo.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiGenerator {
    companion object {
        // 에뮬에서 로컬호스트에 띄운 서버를 지칭할 때 사용하는 ip
        const val HOST = EC2PublicIP.ec2_public_ip
    }

    fun <T> generate(api: Class<T>): T = Retrofit.Builder()
        .baseUrl(HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient())
        .build()
        .create(api)

    // Retrofit을 사용하기 위한 OkHttp 클라이언트 사용
    private fun httpClient() =
        OkHttpClient.Builder().apply {
            addInterceptor(httpLogginInterceptor())
        }.build()

    // API 응답 결과를 로그로 확인
    private fun httpLogginInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}