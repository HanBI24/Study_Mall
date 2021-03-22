package com.example.parayo.common

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice   // 전역 exception handler (모든 controller)
@RestController
class ParayoExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.java)

    // ParayoException.class 타입의 exception이 발생하면 에러 메시지 전달
    @ExceptionHandler(ParayoException::class)   // 해당 class의 타입의 예외를 처리
    fun handleParayoException(e: ParayoException): ApiResponse {
        logger.error("API error", e)
        return ApiResponse.error(e.message)
    }

    // 아니면 "알 수 없는 오류 메시지" 전달
    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ApiResponse {
        logger.error("API error", e)
        return ApiResponse.error("알 수 없는 오류가 발생했습니다.")
    }
}