package ch.lalumash.ToBeHacked.controllers;

import ch.lalumash.ToBeHacked.UserNotFoundOrWrongPasswordException;
import ch.lalumash.ToBeHacked.dto.LoginDto;
import ch.lalumash.ToBeHacked.manager.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LoginController {

    private final LoginManager loginManager;

    @Autowired
    public LoginController(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    @PostMapping("/login")
    public String logIn (@RequestBody LoginDto loginDto) {
        try {
            return this.loginManager.getToken(loginDto);
        } catch (UserNotFoundOrWrongPasswordException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/login/m")
    public String logIn (@RequestBody List<LoginDto> loginDto) {
        try {
            return this.loginManager.getToken(loginDto);
        } catch (UserNotFoundOrWrongPasswordException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
