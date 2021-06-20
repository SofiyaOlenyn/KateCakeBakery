package com.university.confectionary.repositories;

import com.university.confectionary.domain.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findProductEntitiesByProductTypeEntityType(String type);

    Optional<ProductEntity> findProductEntityById(Integer id);

}
