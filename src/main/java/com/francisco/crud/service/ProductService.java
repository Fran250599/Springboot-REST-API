package com.francisco.crud.service;

import com.francisco.crud.model.Product;
import com.francisco.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {

        Optional<Product> res = productRepository.findProductByName(product.getName());
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Error", true);
            data.put("Message", "Ya existe un producto con este nombre.");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }

        data.put("Dato agregado:", product);
        data.put("Message", "Producto creado.");
        productRepository.save(product);
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
        );
    }
}
