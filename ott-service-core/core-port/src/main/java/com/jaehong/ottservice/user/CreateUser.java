package com.jaehong.ottservice.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUser {
    private final String userName;
    private final String encryptedPassword;
    private final String email;
    private final String phone;

    public CreateUser(String userName, String encryptedPassword, String email, String phone) {
        this.userName = userName;
        this.encryptedPassword = encryptedPassword;
        this.email = email;
        this.phone = phone;
    }
}
