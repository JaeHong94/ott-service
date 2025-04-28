package com.jaehong.ottservice.repository.user;

import com.jaehong.ottservice.entity.user.UserEntity;
import com.jaehong.ottservice.user.FetchUserPort;
import com.jaehong.ottservice.user.command.UserPortResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements FetchUserPort {
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<UserPortResponse> findByEmail(String email) {
        Optional<UserEntity> byEmail = userJpaRepository.findByEmail(email);
        if (byEmail.isEmpty()) {
            return Optional.empty();
        }

        return byEmail.map(userEntity -> UserPortResponse.builder()
                .userId(userEntity.getUserId())
                .password(userEntity.getPassword())
                .userName(userEntity.getUserName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .build());
    }
}
