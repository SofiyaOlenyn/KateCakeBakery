package com.university.confectionary.service;

import com.university.confectionary.domain.entities.PermissionEntity;
import com.university.confectionary.domain.entities.UserEntity;
import com.university.confectionary.dto.LoginDto;
import com.university.confectionary.repositories.PermissionRepository;
import com.university.confectionary.repositories.UserRepository;
import com.university.confectionary.utils.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final PermissionRepository permissionRepository;


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

    public String login(LoginDto loginDto) throws Exception {
        String login = loginDto.getLogin();
        String password = loginDto.getPassword();

        List<String> errors = new ArrayList<>();
        Optional<UserEntity> foundUser = userRepository.findByLogin(login);
        if (!foundUser.isPresent()) {
            errors.add("Such username doesn't exist");
        }else {
            if(!bCryptPasswordEncoder.matches(password,foundUser.get().getPassword())){
                errors.add("Password is incorrect");
            }
        }
        if(errors.size() != 0){
            return "Login or password is incorrect";
        }
        return "";
    }

}