package com.example.parayo.intro

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.parayo.api.ParayoApi
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.setContentView
import java.lang.Exception

class IntroActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IntroActivityUI().setContentView(this)

        runBlocking {
            try {
                val response = ParayoApi.instance.hello()
                response.data?.let { Log.d("IntroActivity", it) }
            } catch (e: Exception) {
                Log.e("IntroActivity", "Hello API 호출 오류", e)
            }
        }
    }
}