package com.jaehong.ottservice.repository.user;

import com.jaehong.ottservice.entity.user.UserEntity;
import com.jaehong.ottservice.user.CreateUser;
import com.jaehong.ottservice.user.FetchUserPort;
import com.jaehong.ottservice.user.InsertUserPort;
import com.jaehong.ottservice.user.UserPortResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements FetchUserPort, InsertUserPort {
    private final UserJpaRepository userJpaRepository;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public UserPortResponse create(CreateUser user) {
        UserEntity userEntity = new UserEntity(user.getUserName(), user.getEncryptedPassword(), user.getEmail(), user.getPhone());
        UserEntity save = userJpaRepository.save(userEntity);
        return UserPortResponse.builder()
                .userId(save.getUserId())
                .userName(save.getUserName())
                .password(save.getPassword())
                .email(save.getEmail())
                .phone(save.getPhone())
                .build();
    }
}
