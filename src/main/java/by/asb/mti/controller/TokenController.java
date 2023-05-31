package by.asb.mti.controller;

import by.asb.mti.dto.UserDto;
import by.asb.mti.service.TokenService;
import by.asb.mti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static by.asb.mti.config.bean.URL.*;

@RestController
@RequestMapping(TOKEN)
@RequiredArgsConstructor
public class TokenController {

    private final UserService userService;
    private final TokenService tokenService;

    @PostMapping(LOGIN)
    public ResponseEntity<?> token(UsernamePasswordAuthenticationToken authentication) {
        String accessToken = tokenService.generateAccessToken(authentication);
        String refreshToken = tokenService.generateRefreshToken(authentication);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, accessToken, refreshToken)
                .build();
    }

    @GetMapping(REFRESH)
    public ResponseEntity<?> refreshToken(JwtAuthenticationToken authentication) {
        String accessToken = tokenService.generateAccessToken(authentication);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, accessToken)
                .build();
    }

    @GetMapping(LOGOUT)
    public ResponseEntity<?> logout() {
        String emptyAccessToken = tokenService.createEmptyAccessToken();
        String emptyRefreshToken = tokenService.createEmptyRefreshToken();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, emptyAccessToken, emptyRefreshToken)
                .build();
    }

    @GetMapping(USERINFO)
    public UserDto getUserInfo(Authentication authentication) {
        return userService.findUserByLogin(authentication.getName());
    }

}
