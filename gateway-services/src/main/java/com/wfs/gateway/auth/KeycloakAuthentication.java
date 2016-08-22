package com.wfs.gateway.auth;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by iroyzis on 6/1/2016.
 */
@SuppressWarnings("serial")
public class KeycloakAuthentication implements Authentication{
    private boolean authenticated;
    private String keycloackId;
    private String username;
    private String fullname;
    private Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

    public KeycloakAuthentication(String keycloackId) {
        super();
        this.authenticated = true;
        this.keycloackId = keycloackId;
    }

    public KeycloakAuthentication(boolean authenticated) {
        super();
        this.authenticated = authenticated;
    }



    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return keycloackId;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public static class KeycloakAuthenticationBuilder {
        public static KeycloakAuthentication buildAuthentication(HttpServletRequest request) {
            if(request.getUserPrincipal() != null){
                KeycloakPrincipal kp = (KeycloakPrincipal)request.getUserPrincipal();
                KeycloakAuthentication ka = new KeycloakAuthentication(kp.getKeycloakSecurityContext().getToken().getName());
                String username = kp.getKeycloakSecurityContext().getToken().getPreferredUsername();
                if (username.indexOf("@") != -1)
                    username = username.substring(0, username.indexOf("@"));
                ka.setUsername(username);
                ka.setFullname(kp.getKeycloakSecurityContext().getToken().getName());
                return ka;
            } else {
                return new KeycloakAuthentication(false);
            }
        }

        public static KeycloakAuthentication buildTestAuthentication(String user) {
            KeycloakAuthentication ka = new KeycloakAuthentication(user);
            ka.setUsername(user);
            ka.setFullname(user);
            return ka;
        }

    }

    @Override
    public String getName() {
        return keycloackId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

}