package com.university.confectionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogResponseDto {
    @NotEmpty(message = "Text can not be empty")
    private String name;

    @NotEmpty(message = "Image can not be empty")
    private String catalogImagePath;

    @NotEmpty(message = "Image can not be empty")
    private String catalogImageHoverUrl;

    @NotEmpty(message = "Image can not be empty")
    private String detailedText;

    private Integer enumEquivalent;

    private List<ProductDto> items;
}
