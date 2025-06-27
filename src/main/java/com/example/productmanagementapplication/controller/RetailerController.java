package com.example.productmanagementapplication.controller;

import com.example.productmanagementapplication.entity.Product;
import com.example.productmanagementapplication.entity.Retailer;
import com.example.productmanagementapplication.service.RetailerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/retailers")
public class RetailerController {

    private final RetailerService retailerService;

    public RetailerController(RetailerService retailerService) {
        this.retailerService = retailerService;
    }

    //yeni saticini yaratmagi
    @PostMapping
    public ResponseEntity<Retailer> createRetailer(@Valid @RequestBody Retailer retailer) {
        Retailer saved = retailerService.createRetailer(retailer);
        return ResponseEntity.ok(saved);
    }

    //butun hamisini getir
    @GetMapping
    public ResponseEntity<List<Retailer>> getAllRetailers() {
        return ResponseEntity.ok(retailerService.getAllRetailers());
    }

    //id ile tapib getirsin
    @GetMapping("/{id}")
    public ResponseEntity<Retailer> getRetailerById(@PathVariable Long id) {
        return ResponseEntity.ok(retailerService.getRetailerById(id));
    }

    //saticini update
    @PutMapping("/{id}")
    public ResponseEntity<Retailer> updateRetailer(@PathVariable Long id, @Valid @RequestBody Retailer updatedRetailer) {
        return ResponseEntity.ok(retailerService.updateRetailer(id, updatedRetailer));
    }

    //saticini silmek
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRetailer(@PathVariable Long id) {
        retailerService.deleteRetailer(id);
        return ResponseEntity.noContent().build();
    }

    //saticiya mehsul elave etmek
    @PutMapping("/{id}/products")
    public ResponseEntity<Retailer> addProductsToRetailer(@PathVariable Long id, @RequestBody List<@Valid Product> products) {
        return ResponseEntity.ok(retailerService.addProductsToRetailer(id, products));
    }

    //saticinin mehsullarini elde etmek
    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getRetailerProducts(@PathVariable Long id) {
        return ResponseEntity.ok(retailerService.getProductsByRetailerId(id));
    }

    //retailer id ile mehsullari getirmek
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsByRetailerId(@RequestParam Long retailerId) {
        return ResponseEntity.ok(retailerService.getProductsByRetailerQuery(retailerId));
    }
}
