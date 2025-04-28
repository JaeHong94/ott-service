package com.jaehong.ottservice.user.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private final String userId;
    private final String userName;
    private final String password;
    private final String email;
    private final String phone;
    private final String provider;
    private final String providerId;
    private final String role;
}
