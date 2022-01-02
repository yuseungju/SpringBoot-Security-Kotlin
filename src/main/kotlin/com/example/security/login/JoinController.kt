package com.example.security.login

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/join")
class JoinController(
    val userRepository: IUserRepository,
    val passwordEncoder: PasswordEncoder,
    val userRolesRepository : IUserRolesRepository,
    )
{
    //회원가입 페이지로
    @GetMapping
    fun registerForm() = "join"

    //일반 회원가입 (USER1 , USER2 권한)
    @PostMapping("user_all")
    fun joinUser(model: JoinUser): String
    {
        //유저등록
        var joinUser = model.getUser(passwordEncoder)
        userRepository.save(joinUser)

        //유저1,2 멀티 권한 등록
        userRolesRepository.save(UserRoles(email = model.email, role = AccountRole.ROLE_USER1.name))
        userRolesRepository.save(UserRoles(email = model.email, role = AccountRole.ROLE_USER2.name))
        return "redirect:/login" //가입 후 로그인으로
    }


    //일반 회원가입 (USER1 권한)
    @PostMapping("user1")
    fun joinUser1(model: JoinUser): String
    {
        //유저등록
        var joinUser = model.getUser(passwordEncoder)
        userRepository.save(joinUser)

        //유저1 권한 등록
        userRolesRepository.save(UserRoles(email = model.email, role = AccountRole.ROLE_USER1.name))
        return "redirect:/login" //가입 후 로그인으로
    }

    //일반 회원가입 (USER2 권한)
    @PostMapping("user2")
    fun joinUser2(model: JoinUser): String
    {
        //유저등록
        var joinUser = model.getUser(passwordEncoder)
        userRepository.save(joinUser)

        //유저2 권한 등록
        userRolesRepository.save(UserRoles(email = model.email, role = AccountRole.ROLE_USER2.name))
        return "redirect:/login" //가입 후 로그인으로
    }
}
