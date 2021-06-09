package com.university.confectionary.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDto {
   // @NotEmpty(message = "Text can not be empty")
    //private String name;

    //@NotEmpty(message = "Price can not be empty")
    //private Integer price;

    //@NotEmpty(message = "Weight must be entered")
    //private Integer weight;

    private Integer id;

    //private Integer typeId;
}