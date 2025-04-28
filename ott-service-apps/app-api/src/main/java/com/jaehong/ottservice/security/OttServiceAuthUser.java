package com.jaehong.ottservice.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class OttServiceAuthUser extends User {
    private final String userId;
    private final String userName;
    private final String password;
    private final String email;
    private final String phone;

    public OttServiceAuthUser(String userId, String userName, String password,
                              String email, String phone, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
