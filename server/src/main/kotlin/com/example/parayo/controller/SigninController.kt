package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.auth.SigninRequest
import com.example.parayo.domain.auth.SigninService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class SigninController @Autowired constructor(
    private val signinService: SigninService
) {
    @PostMapping("/signin")
    fun signin(@RequestBody signinRequest: SigninRequest) =
        ApiResponse.ok(signinService.signin(signinRequest))
}