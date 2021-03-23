package com.example.parayo.api.response

data class ApiResponse<T>(
    val success: Boolean,
    val data: T? = null,
    val message: String? = null
) {
    // 오류 응답을 만들어 내기위한 상황 시 사용
    companion object {
        inline fun <reified T> error(message: String? = null)  =
            ApiResponse(false, null as T?, message)
    }
}