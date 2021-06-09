package com.university.confectionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssortementDto {
    @NotEmpty(message = "Text can not be empty")
    private String name;

    @NotEmpty(message = "Image can not be empty")
    private String mainImagePath;

    @NotEmpty(message = "Image can not be empty")
    private String mainImageOnHover;

    @NotEmpty(message = "Image can not be empty")
    private String detailedText;

    private Integer enumEquivalent;
}
