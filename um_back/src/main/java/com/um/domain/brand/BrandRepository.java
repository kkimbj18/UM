package com.um.domain.brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByName(String name);
    Optional<Brand> findById(int id);
    Optional<Brand> findByUserId(int userId);
}
