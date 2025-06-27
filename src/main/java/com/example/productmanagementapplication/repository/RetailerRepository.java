package com.example.productmanagementapplication.repository;


import com.example.productmanagementapplication.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailerRepository extends JpaRepository<Retailer, Long> {
}
