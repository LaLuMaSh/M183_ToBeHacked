package ch.lalumash.ToBeHacked.manager;

import ch.lalumash.ToBeHacked.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class LoginManager {
    HashMap<String, User> users;
    HashMap<String, String> tokens;

    public LoginManager() {
        this.users = new HashMap<>();
        this.users.put("lgu", new User("lgu", "14444"));
        this.users.put("a", new User("lgu", "64212"));
        this.users.put("c", new User("lgu", "1111"));
        this.users.put("d", new User("lgu", "98764"));
        this.users.put("e", new User("lgu", "22221"));
        this.tokens = new HashMap<>();
    }

    public User addUser(User user) {
        this.users.put(user.getUsername(), user);
        return user;
    }

    public Collection<User> getAllUsers() {
        return this.users.values();
    }

    public String getToken(List<User> loginDtoList) {
        for (User loginDto : loginDtoList) {
            String token = getToken(loginDto);
            if (token != null) {
                return token;
            }
        }
        return null;
    }

    public String getToken(User loginDto) {
        if (!users.containsKey(loginDto.getUsername())) {
            return null;
        }

        User user = users.get(loginDto.getUsername());

        if (!user.getPassword().equals(loginDto.getPassword())) {
            return null;
        }

        if (!tokens.containsKey(user.getUsername())) {
            tokens.put(user.getUsername(), UUID.randomUUID().toString());
        }

        return tokens.get(user.getUsername());
    }
}
