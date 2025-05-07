package com.jaehong.ottservice.controller.user.request;

import lombok.Getter;

@Getter
public class UserRegisterRequest {
    private final String userName;
    private final String password;
    private final String email;
    private final String phone;

    public UserRegisterRequest(String userName, String password, String email, String phone) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
