package com.github.saintukrainian.storebackend.authentication;

public class SafeUserCredentials {
    public int id;
    public String firstName;
    public String lastName;
    public String email;

    public SafeUserCredentials() {}

    public SafeUserCredentials(int id, String firstName, String lastName,
            String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public void setSafeUserData(UserCredentials userCredentials) {
        this.setId(userCredentials.getId());
        this.setFirstName(userCredentials.getFirstName());
        this.setLastName(userCredentials.getLastName());
        this.setEmail(userCredentials.getEmail());
    }

    @Override
    public String toString() {
        return "SafeUserCredentials{" + "id=" + id + ", firstName='" + firstName
                + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email
                + '\'' + '}';
    }
}
