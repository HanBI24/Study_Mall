package com.example.parayo.common

// 통일된 API 스펙 만들기 위한
// 응답 데이터 형태의 성공여부, 메시지, 데이터
data class ApiResponse(
    val success: Boolean,
    val data: Any? = null,
    val message: String? = null
) {
    companion object {
        fun ok(data: Any? = null) = ApiResponse(true,  data)
        fun error(message: String? = null) = ApiResponse(false, message = message)
    }
}