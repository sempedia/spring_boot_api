package com.trendyol.homework.controller;

import com.trendyol.homework.entity.Product;
import com.trendyol.homework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles HTTP requests for products (GET, POST, PUT, DELETE).
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * GET /api/products
     * Returns a list of all products from trendyol database.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * GET /api/products/{id}
     * Returns a specific product by their ID.
     *
     * @param id ID of the product to retrieve
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * POST /api/customers
     * Creates a new product from the JSON body.
     *
     * @param product the product data from the request body
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * PUT /api/products/{id}
     * Updates an existing product.
     *
     * @param id             ID of the product to update
     * @param productDetails new product data to replace the old one
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    /**
     * DELETE /api/products/{id}
     * Deletes a product by ID.
     *
     * @param id ID of the product to delete
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
