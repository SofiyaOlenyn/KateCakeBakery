package com.university.confectionary.utils;

import com.university.confectionary.dto.RegistrResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ResponseGenerator {

    public RegistrResponseDto makeRegisterResponse(String message) {
        return RegistrResponseDto.of(message);
    }

}
