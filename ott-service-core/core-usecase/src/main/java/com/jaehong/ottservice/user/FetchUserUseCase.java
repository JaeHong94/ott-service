package com.jaehong.ottservice.user;

import com.jaehong.ottservice.user.response.UserResponse;

public interface FetchUserUseCase {
    UserResponse findUserByEmail(String email);
}
