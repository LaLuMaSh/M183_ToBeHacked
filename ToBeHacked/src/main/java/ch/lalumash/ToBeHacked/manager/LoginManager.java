package ch.lalumash.ToBeHacked.manager;

import ch.lalumash.ToBeHacked.model.User;
import ch.lalumash.ToBeHacked.dto.LoginDto;
import ch.lalumash.ToBeHacked.UserNotFoundOrWrongPasswordException;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class LoginManager {
    HashMap<String, User> users;
    HashMap<String, String> tokens;

    public LoginManager() {
        this.users = new HashMap<>();
        //abcdefg
        this.users.put("lgu", new User("lgu", "132"));
        this.users.put("a", new User("lgu", "64212"));
        this.users.put("c", new User("lgu", "1111"));
        this.users.put("d", new User("lgu", "98764"));
        this.users.put("e", new User("lgu", "22221"));
        this.tokens = new HashMap<>();
    }


    public String getToken(List<LoginDto> loginDtoList) throws UserNotFoundOrWrongPasswordException {
        for (LoginDto loginDto : loginDtoList) {
            String token = getToken(loginDto);
            return token;
        }
        return null;
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
