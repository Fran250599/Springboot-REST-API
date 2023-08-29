package com.francisco.crud.product;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;
    private LocalDate date;
    @Transient
    private int age;

    public Product() {
    }

    public Product(long id, String name, int price, LocalDate date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAge() {
        return Period.between(this.date, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Product(String name, int price, LocalDate date, int age) {
        this.name = name;
        this.price = price;
        this.date = date;
    }
}
