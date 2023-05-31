package by.asb.mti.service;

import org.springframework.security.core.Authentication;

public interface TokenService {
    String generateAccessToken(Authentication authentication);

    String generateRefreshToken(Authentication authentication);

    String createEmptyAccessToken();

    String createEmptyRefreshToken();
}
