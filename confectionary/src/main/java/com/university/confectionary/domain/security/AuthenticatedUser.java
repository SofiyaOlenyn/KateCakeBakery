package com.university.confectionary.domain.security;
import java.util.List;

import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class AuthenticatedUser extends User {

    private final String companyAlias;
    private String token;

    public AuthenticatedUser(
            final String username,
            final String password,
            final List<? extends GrantedAuthority> authorities,
            final String companyAlias
    ) {
        super(username, password, authorities);
        this.companyAlias = companyAlias;
    }
}
