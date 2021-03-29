package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.auth.SignupRequest
import com.example.parayo.domain.auth.SignupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/vl")
class UserApiController @Autowired constructor(
    private val signupService: SignupService
){
    // HTTP의 POST 메서드를 이용해 맵핑된 주소를 호출했을 때 함수 동작
    // 데이터를 저장하는 API는 대부분 POST 메서드를 사용하도록 권장
    @PostMapping("/users")
    // RequestBody: 데이터를 HTTP 바디에서 읽는 것 (URI에 붙는 쿼리 스트링은 보안상 치명)
    fun signup(@RequestBody signupRequest: SignupRequest) =
        ApiResponse.ok(signupService.signup(signupRequest))
}