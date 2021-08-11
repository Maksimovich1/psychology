package com.psychology.psychology.security;

import com.psychology.psychology.domain.SecureObject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.Collections.singletonList;

/**
 * @author andrew.maksimovich
 */

public class CustomUserDetails implements UserDetails {

    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;


    public static CustomUserDetails fromUserEntityToCustomUserDetails(SecureObject secureObject) {
        CustomUserDetails c = new CustomUserDetails();
        c.login = secureObject.getLogin();
        c.password = secureObject.getPassword();
        c.grantedAuthorities = singletonList(new SimpleGrantedAuthority(secureObject.getRole()));
        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    //TODO эти все настройки нужно разработать
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
