package com.example.security.page

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal


@Controller
@RequestMapping("/")
class basicController() {
    //회원가입 페이지로
    @GetMapping("/index")
    fun index() = "index"  //index.html

    //회원가입 페이지로
    @GetMapping("/user1_page")
    fun auth1(): String {
        return "index"  //index.html
    }

    @GetMapping("/user2_page")
    fun auth2() : String {
        return "index"  //index.html
    }

    @GetMapping("/all_page")
    fun auth3(): String {
        return "index"  //index.html
    }

}
