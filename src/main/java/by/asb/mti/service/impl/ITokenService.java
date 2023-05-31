package by.asb.mti.service.impl;

import by.asb.mti.dao.entity.User;
import by.asb.mti.dto.util.DTOConverter;
import by.asb.mti.exception.TokenGenerationException;
import by.asb.mti.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static by.asb.mti.config.bean.Token.ACCESS_TOKEN;
import static by.asb.mti.config.bean.Token.REFRESH_TOKEN;
import static by.asb.mti.config.bean.URL.*;

@Service
@RequiredArgsConstructor
public class ITokenService implements TokenService {
    private final JwtEncoder jwtEncoder;
    private final DTOConverter dtoConverter;

    @Override
    public String generateAccessToken(Authentication authentication) {
        String subject = getSubject(authentication);
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        List<String> scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        JwtClaimsSet jwtToken = JwtClaimsSet.builder()
                .id(UUID.randomUUID().toString())
                .subject(subject)
                .issuer("self")
                .issuedAt(instant)
                .expiresAt(instant.plusSeconds(ACCESS_TOKEN.getExpiration()))
                .claim("scope", scope)
                .build();
        String tokenValue = jwtEncoder.encode(JwtEncoderParameters.from(jwtToken)).getTokenValue();
        ResponseCookie cookie = ResponseCookie
                .from(ACCESS_TOKEN.getValue(), tokenValue)
                .path(ROOT)
                .maxAge(ACCESS_TOKEN.getExpiration())
                .httpOnly(true)
                .secure(false)
                .sameSite("Lax")
                .build();
        return cookie.toString();
    }

    @Override
    public String generateRefreshToken(Authentication authentication) {
        String subject = getSubject(authentication);
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        List<String> scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        JwtClaimsSet jwtToken = JwtClaimsSet.builder()
                .id(UUID.randomUUID().toString())
                .subject(subject)
                .issuer("self")
                .issuedAt(instant)
                .expiresAt(instant.plusSeconds(REFRESH_TOKEN.getExpiration()))
                .claim("scope", scope)
                .build();
        String tokenValue = jwtEncoder.encode(JwtEncoderParameters.from(jwtToken)).getTokenValue();
        ResponseCookie cookie = ResponseCookie
                .from(REFRESH_TOKEN.getValue(), tokenValue)
                .path(CONTEXT_PATH.concat(TOKEN).concat(REFRESH))
                .maxAge(REFRESH_TOKEN.getExpiration())
                .httpOnly(true)
                .secure(false)
                .sameSite("Lax")
                .build();
        return cookie.toString();
    }

    @Override
    public String createEmptyAccessToken() {
        ResponseCookie cookie = ResponseCookie
                .from(ACCESS_TOKEN.getValue(), "")
                .path(ROOT)
                .maxAge(0)
                .httpOnly(true)
                .secure(false)
                .sameSite("Lax")
                .build();
        return cookie.toString();
    }

    @Override
    public String createEmptyRefreshToken() {
        ResponseCookie cookie = ResponseCookie
                .from(REFRESH_TOKEN.getValue(), "")
                .path(CONTEXT_PATH.concat(TOKEN).concat(REFRESH))
                .maxAge(0)
                .httpOnly(true)
                .secure(false)
                .sameSite("Lax")
                .build();
        return cookie.toString();
    }

    private String getSubject(Authentication authentication) {
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            User principal = (User) authentication.getPrincipal();
            return principal.getLogin();
        } else if (authentication instanceof JwtAuthenticationToken) {
            return authentication.getName();
        } else {
            throw new TokenGenerationException("Ошибка генерации токена");
        }
    }
}
