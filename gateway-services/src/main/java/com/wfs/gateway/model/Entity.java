package com.wfs.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by aaltamir on 8/18/16.
 */
public abstract class Entity implements Serializable {
    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_DELETED = "deleted";
    public static final String EVENT_CREATED = "created";
    public static final String EVENT_EDITED = "edited";

    @JsonIgnore
    private boolean admin;

    @JsonIgnore
    private String id;

    public abstract String getId();

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public abstract String getStatus();

    public boolean isActive() {
        return getStatus() == null || getStatus().equalsIgnoreCase(STATUS_ACTIVE);
    }

}
