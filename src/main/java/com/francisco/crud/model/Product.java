package com.francisco.crud.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "`productosBaratico`")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long PLU;
    private String name;
    private String EAN;
    private int price;
    private String description;

    private float weight;
    private int stock;

    public Product() {
    }
    public Product(String name, String EAN, int price, String description, float weight, int stock) {

        this.name = name;
        this.EAN = EAN;
        this.price = price;
        this.description = description;
        this.weight = weight;
        this.stock = stock;
    }

    public long getPLU() {
        return PLU;
    }

    public void setPLU(long PLU) {
        this.PLU = PLU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
