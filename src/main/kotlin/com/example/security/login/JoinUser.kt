package com.example.security.login

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.password.PasswordEncoder

data class JoinUser(
    val email: String?,
    val pass: String?,
    val address: String?,
    val phoneNumber: String?,
    )
{
    fun getUser(passwordEncoder: PasswordEncoder)
    = User( email = email,
        pass = passwordEncoder.encode(pass),
        address = address,
        phoneNumber = phoneNumber,
        userRoles = null
    )
}
