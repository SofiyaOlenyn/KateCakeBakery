package com.university.confectionary.repositories;


import com.university.confectionary.domain.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    Page<OrderEntity> findAll(Pageable pageable);
}
