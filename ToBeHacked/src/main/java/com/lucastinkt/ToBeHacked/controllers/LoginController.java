package com.lucastinkt.ToBeHacked.controllers;

import com.lucastinkt.ToBeHacked.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public String logIn (@RequestBody LoginDto loginDto) {
        return "";
    }
}
