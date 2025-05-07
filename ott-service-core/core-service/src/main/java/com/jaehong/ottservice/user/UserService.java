package com.jaehong.ottservice.user;

import com.jaehong.ottservice.exception.UserException;
import com.jaehong.ottservice.user.command.UserRegistrationCommand;
import com.jaehong.ottservice.user.response.UserRegistrationResponse;
import com.jaehong.ottservice.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements FetchUserUseCase, RegisterUserUseCase {
    private final FetchUserPort fetchUserPort;
    private final InsertUserPort insertUserPort;

    @Override
    public UserResponse findUserByEmail(String email) {
        Optional<UserPortResponse> byEmail = fetchUserPort.findByEmail(email);
        if (byEmail.isEmpty()) {
            throw new UserException.UserDoseNotExistException();
        }

        UserPortResponse userPortResponse = byEmail.get();

        return UserResponse.builder()
                .userId(userPortResponse.getUserId())
                .userName(userPortResponse.getUserName())
                .email(userPortResponse.getEmail())
                .password(userPortResponse.getPassword())
                .phone(userPortResponse.getPhone())
                .role(userPortResponse.getRole())
                .build();
    }

    @Override
    public UserRegistrationResponse register(UserRegistrationCommand command) {
        String email = command.getEmail();
        // 사용자 조회
        Optional<UserPortResponse> byEmail = fetchUserPort.findByEmail(email);
        if (byEmail.isPresent()) {
            throw new UserException.UserAlreadyExistException();
        }

        UserPortResponse response = insertUserPort.create(CreateUser.builder()
                        .userName(command.getUserName())
                        .encryptedPassword(command.getEncryptedPassword())
                        .email(command.getEmail())
                        .phone(command.getPhone())
                        .build());

        return new UserRegistrationResponse(response.getUserName(), response.getEmail(), response.getPhone());
    }
}
