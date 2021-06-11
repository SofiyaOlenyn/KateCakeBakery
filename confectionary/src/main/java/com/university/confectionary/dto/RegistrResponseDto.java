package com.university.confectionary.dto;

import lombok.Data;

@Data(staticConstructor = "of")
public class RegistrResponseDto {

    private final String message;
}