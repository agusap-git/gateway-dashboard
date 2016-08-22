package com.wfs.gateway.model.security;

import java.util.Set;

/**
 * Created by aaltamir on 8/21/16.
 * @author aaltamir
 */
public class UserDetails {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<String> roles;

    /**
     *
     * @param id
     * @param email
     * @param firstName
     * @param lastName
     * @param roles
     */
    public UserDetails(String id, String email, String firstName, String lastName, Set<String> roles) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public UserDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public UserDetails setRoles(Set<String> roles) {
        this.roles = roles;
        return this;
    }
}
