package com.university.confectionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @NotEmpty(message = "Login can not be empty")
    private String login;

    @NotEmpty(message = "Password can not be empty")
    private String password;
}
