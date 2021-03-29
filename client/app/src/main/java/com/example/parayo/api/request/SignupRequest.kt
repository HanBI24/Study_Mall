package com.example.parayo.api.request

import android.util.Patterns

class SignupRequest(
    private val email: String?,
    private val password: String?,
    private val name: String?
) {
    // email 정규 표현식
    fun isNotValidEmail() =
        email.isNullOrBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotValidPassword() =
        password.isNullOrBlank() || password.length !in 8..20

    fun isNotValidName() =
        name.isNullOrBlank() || name.length !in 2..20
}