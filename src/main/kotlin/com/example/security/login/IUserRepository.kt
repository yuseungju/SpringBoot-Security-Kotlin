package com.example.security.login

import org.springframework.data.repository.CrudRepository

interface IUserRepository: CrudRepository<User, String> {
    fun findByEmail(email: String): User?
}
