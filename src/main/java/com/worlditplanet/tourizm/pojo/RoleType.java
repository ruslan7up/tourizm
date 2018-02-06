package com.worlditplanet.tourizm.pojo;

/**
 * Created by Admin on 07.01.2018.
 */

public enum RoleType {
    ROLE_USER("USER"),
    ROLE_MODERATOR("MODERATOR"),
    ROLE_ADMIN("ADMIN");



    private final String value;

    RoleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
}
