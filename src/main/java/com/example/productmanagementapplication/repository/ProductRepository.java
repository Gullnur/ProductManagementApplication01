package com.example.productmanagementapplication.repository;

import com.example.productmanagementapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByRetailerId(Long retailerId);
}
