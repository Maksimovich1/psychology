package com.psychology.psychology.security;

import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;

/**
 * @author andrew.maksimovich
 */
@Component
@Log4j2
public class JwtTokenProvider {

    @Value("${jwt.secret:testSecret}")
    private String jwtSecret;
    @Value("${jwt.dayvalid:10}")
    private int countValidDay;

    /**
     * Генерация токена
     *
     * @param login логин
     * @param pairs дополнительные параметры
     * @return jwt токен
     */
    public String generateAccessToken(String login, List<Pair<String, Object>> pairs) {
        Date date = Date.from(LocalDate.now().plusDays(countValidDay).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(HS512, jwtSecret)
                .compact();
    }

    public String generateRefreshToken(String login, List<Pair<String, Object>> pairs) {
        Date date = Date.from(LocalDate.now().plusDays(countValidDay).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt");
        } catch (SignatureException sEx) {
            log.error("Invalid signature");
        } catch (Exception e) {
            log.error("invalid token");
        }
        return false;
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
