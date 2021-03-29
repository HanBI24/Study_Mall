package com.example.parayo.signup

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import net.codephobia.ankomvvm.components.BaseActivity
import org.jetbrains.anko.setContentView
import kotlin.reflect.KClass

class SignupActivity() : BaseActivity<SignupViewModel>() {
    override val viewModelType = SignupViewModel::class
    // viewModels()는 AppCompatActivity()를 상속받아야 나온다.
//    private val viewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SignupActivityUI(getViewModel()).setContentView(this)
    }
}