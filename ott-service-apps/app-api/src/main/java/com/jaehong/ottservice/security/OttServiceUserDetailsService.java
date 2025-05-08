package com.jaehong.ottservice.security;

import com.jaehong.ottservice.user.FetchUserUseCase;
import com.jaehong.ottservice.user.response.UserResponse;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OttServiceUserDetailsService implements UserDetailsService {
    private final FetchUserUseCase fetchUserUseCase;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserResponse userByEmail = fetchUserUseCase.findUserByEmail(email);
        return new OttServiceAuthUser(
                userByEmail.getUserId(),
                userByEmail.getUserName(),
                userByEmail.getPassword(),
                userByEmail.getEmail(),
                userByEmail.getPhone(),
                List.of(new SimpleGrantedAuthority(StringUtils.isBlank(userByEmail.getRole()) ? "-" : userByEmail.getRole()))

        );
    }
}
