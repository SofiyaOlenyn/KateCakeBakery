package com.university.confectionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findProductEntitiesByProductTypeEntityType(String type);

    Optional<ProductEntity> findProductEntityById(Integer id);

}
