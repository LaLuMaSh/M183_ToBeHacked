package com.lucastinkt.ToBeHacked;

public class UserNotFoundOrWrongPasswordException extends Exception {

    public UserNotFoundOrWrongPasswordException(String message) {
        super(message);
    }
}
