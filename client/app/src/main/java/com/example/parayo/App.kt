package com.example.parayo

import android.app.Application

// 어디서든 context를 참고하기 위해 전역 클래스 생성
class App : Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}