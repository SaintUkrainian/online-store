package com.github.saintukrainian.store_backend.rest_controllers;

import com.github.saintukrainian.store_backend.authentication.LoginData;
import com.github.saintukrainian.store_backend.authentication.RegistrationData;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/register")
    public HttpStatus register(@RequestBody RegistrationData registrationData) {
        System.out.println(registrationData);
        return HttpStatus.OK;
    }

    @PostMapping("/login")
    public HttpStatus login(@RequestBody LoginData loginData) {
        System.out.println(loginData);
        return HttpStatus.OK;
    }
}
