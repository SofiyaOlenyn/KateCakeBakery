package com.university.confectionary.repositories;

import com.university.confectionary.domain.entities.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewsRepository extends JpaRepository<ReviewEntity, Integer> {

    List<ReviewEntity> findAll();

}
