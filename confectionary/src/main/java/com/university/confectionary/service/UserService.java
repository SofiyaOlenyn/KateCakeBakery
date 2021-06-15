package com.university.confectionary.service;

import com.university.confectionary.domain.entities.PermissionEntity;
import com.university.confectionary.domain.entities.UserEntity;
import com.university.confectionary.repositories.PermissionRepository;
import com.university.confectionary.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final PermissionRepository permissionRepository;

    @EventListener
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Optional<UserEntity> usrByUsrnam1 = userRepository.findByLogin("admin-1");
        Optional<UserEntity> usrByUsrnam2 = userRepository.findByLogin("admin-2");
        Optional<PermissionEntity> adminPermission = permissionRepository.findById(1);

        if (!usrByUsrnam1.isPresent() && !usrByUsrnam2.isPresent()) {
            userRepository.save(UserEntity.builder().id(1).login("admin-1").password(bCryptPasswordEncoder.encode("admin1password")).permissions(List.of(adminPermission.get())).build());
            userRepository.save(UserEntity.builder().id(2).login("admin-2").password(bCryptPasswordEncoder.encode("admin2password")).permissions(List.of(adminPermission.get())).build());
        }
    }
}