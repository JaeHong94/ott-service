package com.jaehong.ottservice.user.response;

import lombok.Getter;

@Getter
public class UserRegistrationResponse {
    private final String userName;
    private final String email;
    private final String phone;

    public UserRegistrationResponse(String userName, String email, String phone) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }
}
