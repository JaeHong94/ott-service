package com.jaehong.ottservice.controller.user;

import com.jaehong.ottservice.controller.movie.OttServiceApiResponse;
import com.jaehong.ottservice.controller.user.request.UserRegisterRequest;
import com.jaehong.ottservice.user.RegisterUserUseCase;
import com.jaehong.ottservice.user.command.UserRegistrationCommand;
import com.jaehong.ottservice.user.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/api/v1/user/register")
    public OttServiceApiResponse<UserRegistrationResponse> register(@RequestBody UserRegisterRequest request) {
        UserRegistrationResponse register = registerUserUseCase.register(
                UserRegistrationCommand.builder()
                        .email(request.getEmail())
                        .userName(request.getUserName())
                        .encryptedPassword(passwordEncoder.encode(request.getPassword()))
                        .phone(request.getPhone())
                        .build()
        );

        return OttServiceApiResponse.ok(register);
    }
}
