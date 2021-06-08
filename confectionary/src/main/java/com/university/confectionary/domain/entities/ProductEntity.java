package com.university.confectionary.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "supplements")
    private String supplements;

    @Column(name = "ingredients")
    private String ingredients;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private ProductTypeEntity productTypeEntity;


    @ManyToMany(mappedBy = "productList")
    @ToString.Exclude List<OrderEntity> orders;
}
