package com.jaehong.ottservice.user;

import com.jaehong.ottservice.user.command.UserPortResponse;

import java.util.Optional;

public interface FetchUserPort {
    Optional<UserPortResponse> findByEmail(String email);
}
