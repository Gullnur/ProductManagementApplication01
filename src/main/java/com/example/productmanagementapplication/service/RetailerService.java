package com.example.productmanagementapplication.service;


import com.example.productmanagementapplication.entity.Product;
import com.example.productmanagementapplication.entity.Retailer;
import com.example.productmanagementapplication.exception.ResourceNotFoundException;
import com.example.productmanagementapplication.repository.ProductRepository;
import com.example.productmanagementapplication.repository.RetailerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class RetailerService {

        private final RetailerRepository retailerRepository;
        private final ProductRepository productRepository;

        public RetailerService(RetailerRepository retailerRepository, ProductRepository productRepository) {
            this.retailerRepository = retailerRepository;
            this.productRepository = productRepository;
        }
        //yenisini yaratmaqi
        public Retailer createRetailer(Retailer retailer) {
            return retailerRepository.save(retailer);
        }
        //hamisini getirmek
        public List<Retailer> getAllRetailers() {
            return retailerRepository.findAll();
        }

        //id sine gore tapib getirmek
        public Retailer getRetailerById(Long id) {
            return retailerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Retailer not found with id: " + id));
        }


        //satici melumatlari update
        public Retailer updateRetailer(Long id, Retailer updatedRetailer) {
            Retailer existingRetailer = getRetailerById(id);
            existingRetailer.setName(updatedRetailer.getName());
            existingRetailer.setEmail(updatedRetailer.getEmail());
            return retailerRepository.save(existingRetailer);
        }

        //saticini sil ve elaqeli mehsullari da sil
        public void deleteRetailer(Long id) {
            Retailer retailer = getRetailerById(id);
            retailerRepository.delete(retailer);
        }

        //saticiya mehsul elave etmek
        public Retailer addProductsToRetailer(Long retailerId, List<Product> products) {
            Retailer retailer = getRetailerById(retailerId);
            for (Product product : products) {
                product.setRetailer(retailer);
            }
            retailer.getProducts().addAll(products);
            return retailerRepository.save(retailer);
        }

        //saticinin mehsullarini getirmek
        public List<Product> getProductsByRetailerId(Long retailerId) {
            Retailer retailer = getRetailerById(retailerId);
            return retailer.getProducts(); // Lazy loading burada işləyəcək
        }

        //retailer idsine gore mehsullari getirmek
        public List<Product> getProductsByRetailerQuery(Long retailerId) {
            return productRepository.findByRetailerId(retailerId);
        }
    }
