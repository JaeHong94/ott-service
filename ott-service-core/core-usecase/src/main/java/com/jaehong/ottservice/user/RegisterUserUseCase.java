package com.jaehong.ottservice.user;

import com.jaehong.ottservice.user.command.UserRegistrationCommand;
import com.jaehong.ottservice.user.response.UserRegistrationResponse;

public interface RegisterUserUseCase {
    UserRegistrationResponse register(UserRegistrationCommand command);
}
