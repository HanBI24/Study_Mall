package com.example.parayo.domain.jpa

import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity {

    @Id // 해당 필드가 이 테이블의 기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 테이블에 새 데이터가 저장될 때, 자동으로 1 증가
    // MySQL이 생성해준 값을 JPA가 입력해 줌
    open var id: Long? = null
    // JPA의 라이프사이클 훅을 이용해 자동으로 입력해 주기 위해
    open var create_at: Date? = null
    open var update_at: Date? = null

    // 새 데이터가 저장되기 전에 자동으로 호출
    @PrePersist
    fun prePersist() {
        create_at = Date()
        update_at = Date()
    }

    // JPA 라이프사이클 훅 지정
    // db가 업데이트 명령 내리기 전에 실행
    @PreUpdate
    fun preUpdate() {
        update_at = Date()
    }
}