package com.lucastinkt.ToBeHacked.manager;

import com.lucastinkt.ToBeHacked.dto.LoginDto;
import com.lucastinkt.ToBeHacked.UserNotFoundOrWrongPasswordException;
import com.lucastinkt.ToBeHacked.model.User;

import java.util.HashMap;
import java.util.UUID;

public class LoginManager {
    HashMap<String, User> users;
    HashMap<String, String> tokens;

    public LoginManager() {
        this.users = new HashMap<>();
        this.users.put("lgu", new User("lgu", "abc"));
        this.users.put("a", new User("lgu", "cool"));
        this.users.put("c", new User("lgu", "lucguett"));
        this.users.put("d", new User("lgu", "guettlgu"));
        this.users.put("e", new User("lgu", "random"));
        this.tokens = new HashMap<>();
    }

    public String getToken(LoginDto loginDto) throws UserNotFoundOrWrongPasswordException {
        if (!users.containsKey(loginDto.getUsername())) {
            throw new UserNotFoundOrWrongPasswordException("User " + loginDto.getUsername() + " not found or invalid password.");
        }

        User user = users.get(loginDto.getUsername());

        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new UserNotFoundOrWrongPasswordException("User " + loginDto.getUsername() + " not found or invalid password.");
        }

        if (!tokens.containsKey(user.getUsername())) {
            tokens.put(user.getUsername(), UUID.randomUUID().toString());
        }

        return tokens.get(user.getUsername());
    }
}
