package com.jaehong.ottservice.authentication;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationHolerImpl implements AuthenticationHolder, RequestedByProvider {
    private Authentication authentication;

    @Override
    public Optional<Authentication> getAuthentication() {
        return Optional.of(authentication);
    }

    @Override
    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public Optional<String> getRequestedBy() {
        return getAuthentication()
                .map(Authentication::getRequestedBy);
    }
}
