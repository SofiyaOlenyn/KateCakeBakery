package com.university.confectionary.dto;

import com.university.confectionary.domain.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;

@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDto {
    @NotEmpty(message = "Text can not be empty")
    private String name;

    @NotEmpty(message = "Price can not be empty")
    private Integer price;

    @NotEmpty(message = "Weight must be entered")
    private Integer weight;

    @NotEmpty(message = "Image can not be empty")
    private String mainPhoto;

    @NotEmpty
    private String supplements;

    @NotEmpty
    private String ingredients;

    private Integer id;

    private String productType;

    public ProductDetailsDto(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.productType = productEntity.getProductTypeEntity().getType();
        this.mainPhoto = productEntity.getImageUrl();
        this.name = productEntity.getName();
        this.ingredients = productEntity.getIngredients();
        this.supplements = productEntity.getSupplements();
        this.price = productEntity.getPrice();
        this.weight = productEntity.getWeight();
    }
}