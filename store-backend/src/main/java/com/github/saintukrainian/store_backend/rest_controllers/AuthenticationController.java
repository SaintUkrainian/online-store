package com.github.saintukrainian.store_backend.rest_controllers;

import com.github.saintukrainian.store_backend.authentication.LoginData;
import com.github.saintukrainian.store_backend.authentication.SafeUserCredentials;
import com.github.saintukrainian.store_backend.authentication.UserCredentials;

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

    @PostMapping("/register")
    public HttpStatus register(@RequestBody UserCredentials userCredentials) {
        boolean registered = authenticationService
                .registerNewUser(userCredentials);
        return registered ? HttpStatus.OK : HttpStatus.ALREADY_REPORTED;
    }

    @PostMapping("/login")
    public SafeUserCredentials login(@RequestBody LoginData loginData) {
        boolean loggedIn = authenticationService.loginUser(loginData);
        if(loggedIn) {
            UserCredentials userCredentials = authenticationService.getUserCredentials(loginData);
            SafeUserCredentials safeUserCredentials = new SafeUserCredentials();

            safeUserCredentials.setId(userCredentials.getId());
            safeUserCredentials.setFirstName(userCredentials.getFirstName());
            safeUserCredentials.setLastName(userCredentials.getLastName());
            safeUserCredentials.setEmail(userCredentials.getEmail());

            return safeUserCredentials;
        } else {
            throw new NoSuchElementException();
        }
    }
}
