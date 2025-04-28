package com.jaehong.ottservice.user;

import com.jaehong.ottservice.user.command.UserResponse;

public interface FetchUserUseCase {
    UserResponse findUserByEmail(String email);
}
