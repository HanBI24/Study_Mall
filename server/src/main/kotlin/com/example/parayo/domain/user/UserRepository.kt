package com.example.parayo.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// spring이 관리하는 repository bean으로써 동작
// repository: 데이터의 읽기/쓰기 담당
@Repository
// JpaRepository: repository를 JPA 스펙에 맞게 확장하면서 기본적인 CRUD 제공
interface UserRepository : JpaRepository<User, Long> {
    // findByEmail() 메서드 호출만으로 SQL을 작성하지 않고도 db 검색이 가능해짐
    // 이메일로 검색했을 때, 한 명 혹은 0명의 유저만 존재해야 하기 때문에 User?를 반환 타입으로 사용
    fun findByEmail(email: String): User?
}