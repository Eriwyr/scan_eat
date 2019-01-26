package com.codev.scan_eat_api.entities;

import com.codev.scan_eat_api.security.SecuredUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private SecuredUser securedUser;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public SecuredUser getSecuredUser() {
        return securedUser;
    }

    public void setSecuredUser(SecuredUser securedUser) {
        this.securedUser = securedUser;
    }
}
