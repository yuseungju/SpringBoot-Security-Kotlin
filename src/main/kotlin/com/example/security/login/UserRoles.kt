package com.example.security.login
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class UserRoles(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val seq: Long? = null,
    val email: String?,
    val role: String?,
)