package com.jaehong.ottservice.user;

import com.jaehong.ottservice.user.command.UserPortResponse;
import com.jaehong.ottservice.user.command.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements FetchUserUseCase {
    private final FetchUserPort fetchUserPort;

    @Override
    public UserResponse findUserByEmail(String email) {
        Optional<UserPortResponse> byEmail = fetchUserPort.findByEmail(email);
        if (byEmail.isEmpty()) {
            throw new RuntimeException();
        }

        UserPortResponse userPortResponse = byEmail.get();

        return new UserResponse().builder()
                .userId(userPortResponse.getUserId())
                .userName(userPortResponse.getUserName())
                .email(userPortResponse.getEmail())
                .password(userPortResponse.getPassword())
                .phone(userPortResponse.getPhone())
                .role(userPortResponse.getRole())
                .build();
    }
}
