package me.matamor.backend.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;

    public String generateToken(Authentication authentication) throws JwtException {
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(JWT_TOKEN_VALIDITY))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String getUsernameFromToken(String token) throws JwtException {
        return getClaimFromToken(token, Jwt::getSubject);
    }

    public Instant getExpirationDateFromToken(String token) throws JwtException {
        return getClaimFromToken(token, Jwt::getExpiresAt);
    }

    public <T> T getClaimFromToken(String token, Function<Jwt, T> claimsResolver) throws JwtException {
        Jwt claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Jwt getAllClaimsFromToken(String token) throws JwtException {
        return this.jwtDecoder.decode(token);
    }

    private boolean isTokenExpired(String token) throws JwtException {
        Instant expiration = getExpirationDateFromToken(token);
        return expiration.isBefore(Instant.now());
    }
}