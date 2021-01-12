package com.github.saintukrainian.store_backend.rest_controllers;

import com.github.saintukrainian.store_backend.authentication.LoginData;
import com.github.saintukrainian.store_backend.authentication.UserCredentials;

import com.github.saintukrainian.store_backend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(
            AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public HttpStatus register(@RequestBody UserCredentials userCredentials) {
        boolean registered = authenticationService
                .registerNewUser(userCredentials);
        return registered ? HttpStatus.OK : HttpStatus.ALREADY_REPORTED;
    }

    @PostMapping("/login")
    public HttpStatus login(@RequestBody LoginData loginData) {
        boolean loggedIn = authenticationService.loginUser(loginData);
        return loggedIn ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
