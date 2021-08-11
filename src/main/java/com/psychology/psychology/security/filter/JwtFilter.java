package com.psychology.psychology.security.filter;

import com.psychology.psychology.security.CustomUserDetails;
import com.psychology.psychology.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

/**
 * @author andrew.maksimovich
 */
@Component
@Log4j2
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION = "Authorization";

    @Value("${security.prefix:Bearer}")
    public String prefixToken;

    private final JwtTokenProvider tokenProvider;
    private final UserDetailsService userDetailsService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        getTokenFromRequest((HttpServletRequest) servletRequest).ifPresent(token -> {
            String userLogin = tokenProvider.getLoginFromToken(token);
            CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(userLogin);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        });
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Optional<String> getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION);
        if (hasText(bearerToken) && bearerToken.startsWith(prefixToken + " ")) {
            int countUselessSymbols = AUTHORIZATION.length() + prefixToken.length() + 1;
            String token = bearerToken.substring(countUselessSymbols);
            if (tokenProvider.validateToken(token)) {
                return Optional.of(token);
            }
        }
        return Optional.empty();
    }
}
