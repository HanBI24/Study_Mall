package com.example.parayo.api.request

import android.util.Patterns

class SigninRequest(
        private val email: String?,
        private val password: String?
) {
    fun isNotValidEmail() = email.isNullOrBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotValidPassword() = password.isNullOrBlank() || password.length !in 8..20
}