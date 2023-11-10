package com.francisco.crud.controller;

import com.francisco.crud.model.Product;
import com.francisco.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        List<Product> products = productService.getProducts();

        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> registerProduct(@RequestBody Product product){
        return productService.newProduct(product);
    }

    

}
