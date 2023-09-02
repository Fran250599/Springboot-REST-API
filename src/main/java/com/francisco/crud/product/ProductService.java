package com.francisco.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
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

    public void newProduct(Product product) {

        Optional<Product> res = productRepository.findProductByName(product.getName());
        if(res.isPresent()){
            throw new IllegalStateException("Ya existe el producto.");
        }
        productRepository.save(product);
    }
}