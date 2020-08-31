package ch.lalumash.ToBeHacked.controllers;

import ch.lalumash.ToBeHacked.manager.LoginManager;
import ch.lalumash.ToBeHacked.model.User;
import ch.lalumash.core.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class LoginController {

    private final LoginManager loginManager;

    @Autowired
    public LoginController(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    @PostMapping("/add")
    public User add(@RequestBody User loginDto) {
        return this.loginManager.addUser(loginDto);
    }

    @GetMapping("/getAll")
    public Collection<User> getAll() {
        return this.loginManager.getAllUsers();
    }

    @PostMapping("/login")
    public LoginResponseDto logIn(@RequestBody User loginDto) {
        return new LoginResponseDto(this.loginManager.getToken(loginDto));
    }

    @PostMapping("/login/m")
    public LoginResponseDto logIn(@RequestBody List<User> loginDto) {
        return new LoginResponseDto(this.loginManager.getToken(loginDto));
    }
}
