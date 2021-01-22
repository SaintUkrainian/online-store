package com.github.saintukrainian.store_backend.rest_controllers;

import com.github.saintukrainian.store_backend.authentication.LoginData;
import com.github.saintukrainian.store_backend.authentication.SafeUserCredentials;
import com.github.saintukrainian.store_backend.authentication.UserCredentials;

import com.github.saintukrainian.store_backend.exceptions.UserAlreadyRegisteredException;
import com.github.saintukrainian.store_backend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(
            AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @ExceptionHandler
    public HttpStatus userNotFound(NoSuchElementException e) {
        return HttpStatus.NOT_FOUND;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public UserAlreadyRegisteredException userAlreadyRegistered(
            IllegalArgumentException e) {
        return new UserAlreadyRegisteredException(e.getMessage());
    }

    @PostMapping("/register")
    public SafeUserCredentials register(
            @RequestBody UserCredentials userCredentials)
            throws IllegalArgumentException {
        boolean registered = authenticationService
                .registerNewUser(userCredentials);
        if (registered) {
            SafeUserCredentials safeUserCredentials = new SafeUserCredentials();
            safeUserCredentials.setSafeUserData(userCredentials);

            return safeUserCredentials;
        } else {
            throw new IllegalArgumentException("User already registered!");
        }

    }

    @PostMapping("/login")
    public SafeUserCredentials login(@RequestBody LoginData loginData) {
        boolean loggedIn = authenticationService.loginUser(loginData);
        if (loggedIn) {
            UserCredentials userCredentials = authenticationService
                    .getUserCredentials(loginData);

            SafeUserCredentials safeUserCredentials = new SafeUserCredentials();
            safeUserCredentials.setSafeUserData(userCredentials);

            return safeUserCredentials;
        } else {
            throw new NoSuchElementException();
        }
    }
}
