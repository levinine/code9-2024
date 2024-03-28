package com.levinine.codenine.secured.entities;

import lombok.Getter;

@Getter
public enum Role {
    USER("user", "ROLE_USER"),
    ADMIN("admin", "ROLE_ADMIN");

    private final String text;
    private final String authorityName;

    Role(String text, String authorityName) {
        this.text = text;
        this.authorityName = authorityName;
    }
}
