package com.university.confectionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    @NotEmpty(message = "Text can not be empty")
    private String text;

    @NotEmpty
    private String author;

    private Integer id;
}