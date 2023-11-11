package com.francisco.crud.repository;

import com.francisco.crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Since the id of the products is a field called PLU, we need to create a custom method to find by PLU
    Optional<Product> findProductByPLU(Long PLU);
    Optional<Product> findProductByName(String name);
}
