package com.github.saintukrainian.storebackend.exceptions;

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
