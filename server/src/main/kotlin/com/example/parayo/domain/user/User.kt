package com.example.parayo.domain.user

import java.util.*
import javax.persistence.*

// 이 클래스가 db 테이블에 맵핑된 정보를 가지고 있음
// 이 클래스의 객체가 가진 데이터는 db에 저장된 혹은 저장될 사용자 한 병의 정보를 대변
@Entity(name = "user")
class User(
    var email: String,
    var password: String,
    var name: String
) {
    @Id // 해당 필드가 이 테이블의 기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 테이블에 새 데이터가 저장될 때, 자동으로 1 증가
    // MySQL이 생성해준 값을 JPA가 입력해 줌
    var id: Long? = null
    // JPA의 라이프사이클 훅을 이용해 자동으로 입력해 주기 위해
    var createdAt: Date? = null
    var updatedAt: Date? = null

    // 새 데이터가 저장되기 전에 자동으로 호출
    @PrePersist
    fun prePersist() {
        createdAt = Date()
        updatedAt = Date()
    }

    // JPA 라이프사이클 훅 지정
    // db가 업데이트 명령 내리기 전에 실행
    @PreUpdate
    fun preUpdate() {
        updatedAt = Date()
    }
}