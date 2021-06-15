package com.university.confectionary.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_type")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductTypeEntity {

    public ProductTypeEntity(Integer id, String type, String name, String catalogImageUrl, String catalogImageHoverUrl, String detailedText, Integer enumEquivalent, List<ProductEntity> products) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.catalogImageUrl = catalogImageUrl;
        this.catalogImageHoverUrl = catalogImageHoverUrl;
        this.detailedText = detailedText;
        this.enumEquivalent = enumEquivalent;
        this.products = products;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "catalog_image_url")
    private String catalogImageUrl;

    @Column(name = "catalog_image_hover_url")
    private String catalogImageHoverUrl;

    @Column(name = "detailed_text")
    private String detailedText;

    @Column(name = "enum_equivalent")
    private Integer enumEquivalent;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ProductEntity> products;

}
