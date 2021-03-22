package com.example.parayo.common

import java.lang.RuntimeException

// exception을 캐치하여 메시지 전파
class ParayoException(message: String) : RuntimeException(message) {
}