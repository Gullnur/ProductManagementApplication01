package com.example.productmanagementapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductDto {
    private Long id;

    @NotBlank(message = "name bos olmamalidir")
    private String name;

    @Positive(message = "Price natural eded olmalidir")
    private Double price;

    private Long retailerId;
}