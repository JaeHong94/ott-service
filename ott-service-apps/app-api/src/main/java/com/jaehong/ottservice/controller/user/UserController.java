package com.jaehong.ottservice.controller.user;

import com.jaehong.ottservice.controller.OttServiceApiResponse;
import com.jaehong.ottservice.controller.user.request.UserLoginRequest;
import com.jaehong.ottservice.controller.user.request.UserRegisterRequest;
import com.jaehong.ottservice.security.OttServiceAuthUser;
import com.jaehong.ottservice.user.RegisterUserUseCase;
import com.jaehong.ottservice.user.command.UserRegistrationCommand;
import com.jaehong.ottservice.user.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/api/v1/user/register")
    public OttServiceApiResponse<UserRegistrationResponse> register(@RequestBody UserRegisterRequest request) {
        UserRegistrationResponse register = registerUserUseCase.register(
                UserRegistrationCommand.builder()
                        .email(request.getEmail())
                        .userName(request.getUserName())
//                        .encryptedPassword(passwordEncoder.encode(request.getPassword()))
                        .encryptedPassword(request.getPassword())
                        .phone(request.getPhone())
                        .build()
        );

        return OttServiceApiResponse.ok(register);
    }

    @PostMapping("/api/v1/user/login")
    public OttServiceApiResponse<String> login(@RequestBody UserLoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(token);

        OttServiceAuthUser principal = (OttServiceAuthUser) authenticate.getPrincipal();

        return OttServiceApiResponse.ok("access-token");
    }
}
