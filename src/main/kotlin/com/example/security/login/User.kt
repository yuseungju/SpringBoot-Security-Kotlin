package com.example.security.login

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors
import javax.persistence.*

@Entity
data class User(
    @Id
    val email: String?,
    val pass: String?,
    val address: String?,
    val phoneNumber: String?,

    @OneToMany(fetch=FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name="email")
    val userRoles : Collection<UserRoles>?
    ) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return userRoles?.stream()?.map { userRole -> SimpleGrantedAuthority(userRole.role)}?.collect(Collectors.toSet())
    }
    override fun getPassword() = pass
    override fun getUsername() = email
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}

