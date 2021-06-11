package com.university.confectionary.repositories;

import com.university.confectionary.domain.entities.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Integer> {

    ProductTypeEntity findProductTypeEntityById(Integer id);

    ProductTypeEntity findProductTypeEntityByType(String type);

}