package com.example.productmanagementapplication.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class RetailerDto {
    private Long id;

    @NotBlank(message = "Retailer name cannot be blank")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private List<ProductDto> products;

}
