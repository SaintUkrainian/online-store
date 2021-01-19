package com.github.saintukrainian.store_backend.service;

import com.github.saintukrainian.store_backend.authentication.LoginData;
import com.github.saintukrainian.store_backend.authentication.UserCredentials;
import com.github.saintukrainian.store_backend.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthenticationService {

    private UserDAO userDAO;

    @Autowired
    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public boolean registerNewUser(UserCredentials userCredentials) {
        return userDAO.registerNewUser(userCredentials);
    }

    @Transactional
    public boolean loginUser(LoginData loginData) {
        return userDAO.loginUser(loginData);
    }

    @Transactional
    public UserCredentials getUserCredentials(LoginData loginData) {
        return userDAO.getUserCredentials(loginData);
    }
}
