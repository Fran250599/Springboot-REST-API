package com.francisco.crud.controller;

import com.francisco.crud.model.Product;
import com.francisco.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "products")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }



    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Object> registerProduct(@RequestBody Product product){
        return productService.newProduct(product);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }




}
