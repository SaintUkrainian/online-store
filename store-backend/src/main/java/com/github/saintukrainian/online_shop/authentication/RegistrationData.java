package com.github.saintukrainian.online_shop.authentication;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class RegistrationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    public RegistrationData() {
    }

    public RegistrationData(int id, String firstName, String lastName,
            String email, String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "RegistrationData{" + "id=" + id + ", firstName='" + firstName
                + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email
                + '\'' + ", login='" + login + '\'' + ", password='" + password
                + '\'' + '}';
    }
}
