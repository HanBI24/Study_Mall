package com.example.parayo.domain.auth

import com.example.parayo.common.ParayoException
import com.example.parayo.domain.user.User
import com.example.parayo.domain.user.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SigninService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun signin(signinRequest: SigninRequest): SigninResponse {
        val user =
            userRepository.findByEmail(signinRequest.email.toLowerCase()) ?: throw ParayoException("로그인 정보를 확인해주세요.")

        if(isNotValidPassword(signinRequest.password, user.password))
            throw ParayoException("로그인 정보를 확인해주세요.")

        return responseWithTokens(user)
    }

    private fun isNotValidPassword(
        plain: String,
        hashed: String
    ) = BCrypt.checkpw(plain, hashed).not() // db의 비밀번호 hash 값이랑 같을 경우 token 반환

    private fun responseWithTokens(user: User) = user.id?.let { userId ->
        SigninResponse(
            JWTUtil.createToken(user.email),
            JWTUtil.createRefreshToken(user.email),
            user.name,
            userId
        )
    } ?: throw ParayoException("user.id 없음.")
}