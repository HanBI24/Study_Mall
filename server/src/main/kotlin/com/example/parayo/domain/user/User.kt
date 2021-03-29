package com.example.parayo.domain.user

import com.example.parayo.domain.jpa.BaseEntity
import java.util.*
import javax.persistence.*

// 이 클래스가 db 테이블에 맵핑된 정보를 가지고 있음
// 이 클래스의 객체가 가진 데이터는 db에 저장된 혹은 저장될 사용자 한 병의 정보를 대변
@Entity
@Table(name="user")
class User(
    var email: String,
    var password: String,
    var name: String
) : BaseEntity()