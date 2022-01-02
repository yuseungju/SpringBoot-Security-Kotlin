package com.example.security.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/user1_page")
            .access("hasRole('ROLE_USER1')")
            .antMatchers("/user2_page")
            .access("hasRole('ROLE_USER2')")
            .antMatchers("/", "/**").access("permitAll")
            .and() .formLogin() .loginPage("/login") .defaultSuccessUrl("/index",true)
            .and() .logout() .logoutSuccessUrl("/index")
            .and(). csrf().disable() //나중에 html 조작 방지하려면 추가

    }

    @Throws(java.lang.Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(daoAuthenticationProvider())
    }

    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    @Bean
    fun encoder() = BCryptPasswordEncoder()

    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider? {
        val provider = DaoAuthenticationProvider()
        provider.setPasswordEncoder(encoder())
        provider.setUserDetailsService(userDetailsService)
        return provider
    }
}
