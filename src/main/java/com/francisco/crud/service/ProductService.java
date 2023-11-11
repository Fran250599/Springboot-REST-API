package com.francisco.crud.service;

import com.francisco.crud.model.Product;
import com.francisco.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        return productRepository.findAll();
    }

    // Get product by id
    public ResponseEntity<Object> getProductById(Long id) {

        Optional<Product> res = productRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Dato encontrado:", res.get());
            data.put("Message", "Producto encontrado.");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }

        data.put("Error", true);
        data.put("Message", "No existe un producto con este id.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
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

    // Update product
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, Product product) {

        Optional<Product> res = productRepository.findProductByPLU(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Dato actualizado:", product);
            data.put("Message", "Producto actualizado.");
            productRepository.save(product);
            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }

        data.put("Error", true);
        data.put("Message", "No existe un producto con este id.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }

    // Delete product
    public ResponseEntity<Object> deleteProduct(Long product) {

        Optional<Product> res = productRepository.findById(product);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Dato eliminado:", product);
            data.put("Message", "Producto eliminado.");
            productRepository.delete(res.get());
            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }

        data.put("Error", true);
        data.put("Message", "No existe un producto con este nombre.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }
}
