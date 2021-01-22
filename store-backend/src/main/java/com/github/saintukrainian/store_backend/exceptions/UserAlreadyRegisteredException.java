package com.github.saintukrainian.store_backend.exceptions;

import com.github.saintukrainian.store_backend.authentication.UserCredentials;

public class UserAlreadyRegisteredException {
    private String message;

    public UserAlreadyRegisteredException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "UserAlreadyRegisteredException{" + "message='" + message + '\''
                + '}';
    }
}
