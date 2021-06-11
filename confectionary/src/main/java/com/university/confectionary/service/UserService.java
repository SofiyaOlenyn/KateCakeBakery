package com.university.confectionary.service;

import com.university.confectionary.domain.entities.UserEntity;
import com.university.confectionary.domain.type.Permission;
import com.university.confectionary.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Boolean createUser(String username, String password, Permission permission){
        var user = userRepository.findByLogin(username);
        if (user.isPresent()) {
            return false;
        }

        var newUser = UserEntity.builder().login(username).password(password).build();
        userRepository.saveAndFlush(newUser);
        return true;
    }

    @Transactional
    public Boolean createUser(String username, String password){
        return createUser(username, password, Permission.VIEW_CATALOG);
    }


}