package com.example.security.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(@Autowired val userRepository: IUserRepository)
    : UserDetailsService { @Throws(UsernameNotFoundException::class)

    // 회원정보 조회 , 권한리스트도 조회하여 세팅
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByEmail(username)
        return user ?: throw UsernameNotFoundException("loadUserByUsername() - cannot find username:$username)")
    }
}
