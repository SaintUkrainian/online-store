package com.github.saintukrainian.online_shop.authentication;

public class LoginData {
    private String login;
    private String password;

    public LoginData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginData{" + "login='" + login + '\'' + ", password='"
                + password + '\'' + '}';
    }
}
