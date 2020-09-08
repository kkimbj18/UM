package com.um.domain.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByUser_UserId(@Param(value="userId") int userId);
    Optional<Brand> findByName(String name);
    Optional<Brand> findById(int id);
}
