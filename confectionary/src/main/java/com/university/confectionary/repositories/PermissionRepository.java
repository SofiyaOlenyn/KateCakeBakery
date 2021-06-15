package com.university.confectionary.repositories;

import com.university.confectionary.domain.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository  extends JpaRepository<PermissionEntity, Integer> {
    Optional<PermissionEntity> findById(Integer id);
}
