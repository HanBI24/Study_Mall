package com.example.parayo.domain.auth

import com.example.parayo.common.ParayoException
import com.example.parayo.domain.user.User
import com.example.parayo.domain.user.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

// Service: bean 클래스임을 나태냄. 비즈니스 로직을 처리하는 클래스임을 표시
@Service
// Autowired: bean 클래스를 자동으로 주입
class SignupService @Autowired constructor(
    private val userRepository: UserRepository  // 사용자 데이터를 읽기 위한
) {
    fun signup(signupRequest: SignupRequest) {
        validateRequest(signupRequest)          // 1. 이메일 형식 검증
        checkDuplicates(signupRequest.email)    // 2. 이메일 중복 검사
        registerUser(signupRequest)             // 3. 회원 데이터 저장
    }

    private fun validateRequest(signupRequest: SignupRequest) {
        validateEmail(signupRequest.email)
        validateName(signupRequest.name)
        validatePassword(signupRequest.password)
    }

    private fun validateEmail(email: String) {
        val isNotValidEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
            .toRegex(RegexOption.IGNORE_CASE)
            .matches(email)
            .not()

        if(isNotValidEmail) {
            throw ParayoException("이메일 형식이 올바르지 않습니다.")
        }
    }

    private fun validateName(name: String) {
        if(name.trim().length !in 2..20) {
            throw ParayoException("이름은 2자 이상 20자 이하여야 합니다.")
        }
    }

    private fun validatePassword(password: String) {
        if(password.trim().length !in 8..20) {
            throw ParayoException("비밀번호는 공백을 제외하고 8자 이상 20자 이햐여야 합니다.")
        }
    }

    private fun checkDuplicates(email: String) {
        userRepository.findByEmail(email)?.let { throw ParayoException("이미 사용 중인 이메일입니다.") }
    }

    private fun registerUser(signupRequest: SignupRequest) =
        with(signupRequest) {
            val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
            val user = User(email, hashedPassword, name)
            // JpaRepository 클래스에 save() 메서드 구현되어 있음
            userRepository.save(user)
        }
}