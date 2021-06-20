package com.university.confectionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatedOrderDto {
    private Integer id;

    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotEmpty(message = "Surname can not be empty")
    private String surname;

    @NotEmpty(message = "Email can not be empty")
    private String email;

    @NotEmpty(message = "Phone can not be empty")
    private String phone;

    private boolean done;

    private List<ProductOrderForAdminDto> products;

}
