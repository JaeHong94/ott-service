package com.jaehong.ottservice.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OttServiceUser {
    private final String userId;
    private final String userName;
    private final String encryptedPassword;
    private final String email;
    private final String phone;
    private final String provider;
    private final String providerId;
    private final String role;

    public OttServiceUser(String userId, String userName, String encryptedPassword, String email, String phone, String provider, String providerId, String role) {
        this.userId = userId;
        this.userName = userName;
        this.encryptedPassword = encryptedPassword;
        this.email = email;
        this.phone = phone;
        this.provider = provider;
        this.providerId = providerId;
        this.role = role;
    }
}
