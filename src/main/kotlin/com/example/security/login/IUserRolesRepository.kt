package com.example.security.login

import org.springframework.data.repository.CrudRepository

interface IUserRolesRepository: CrudRepository<UserRoles, String> {
    fun findByEmail(email: String): UserRoles?
}
