package com.lucastinkt.ToBeHacked.controllers;

import com.lucastinkt.ToBeHacked.UserNotFoundOrWrongPasswordException;
import com.lucastinkt.ToBeHacked.dto.LoginDto;
import com.lucastinkt.ToBeHacked.manager.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LoginController {

    private final LoginManager loginManager;

    @Autowired
    public LoginController(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    @RequestMapping("/login")
    public String logIn (@RequestBody LoginDto loginDto) {
        try {
            return this.loginManager.getToken(loginDto);
        } catch (UserNotFoundOrWrongPasswordException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
