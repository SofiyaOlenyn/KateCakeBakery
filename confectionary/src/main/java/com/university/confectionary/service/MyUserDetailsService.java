package com.university.confectionary.service;


import com.university.confectionary.domain.entities.PermissionEntity;
import com.university.confectionary.domain.entities.UserEntity;
import com.university.confectionary.domain.security.AuthenticatedUser;
import com.university.confectionary.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthenticatedUser loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserEntity user = userRepository.findByLogin(username)
            .orElseThrow(() -> new UsernameNotFoundException("No user with login: " + username));

        return new AuthenticatedUser(
            username,
            user.getPassword(),
            mapAuthorities(user.getPermissions())
        );
    }

    private static List<GrantedAuthority> mapAuthorities(final List<PermissionEntity> permissions) {
        return permissions.stream()
            .map(PermissionEntity::getPermission)
            .map(Enum::name)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toUnmodifiableList());
    }
}
