package com.university.confectionary.controller;


import com.university.confectionary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final ResponseGenerator responseGenerator;
    private final UserService userService;


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<RegistrResponseDto> addFavorite(
            @Valid @RequestBody final UserCredentialsDto userCredentialsDto
    ) {
        if (userService.createUser(userCredentialsDto.getUsername(), userCredentialsDto.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header(HttpHeaders.AUTHORIZATION, "generated-jwt-token")
                    .body(responseGenerator.makeRegisterResponse("Account created"));
        } else {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .header(HttpHeaders.AUTHORIZATION, "generated-jwt-token")
                    .body(responseGenerator.makeRegisterResponse("User already exists"));
        }
    }

}