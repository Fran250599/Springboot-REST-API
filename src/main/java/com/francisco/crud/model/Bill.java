package com.francisco.crud.model;

import jakarta.persistence.*;

@Entity
@Table
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billNumber;

    private String articleDetail;
    private int quantity;
    private float subtotal;
    private float total;
    private String cashier;
    private String date;
    private String time;

    public Bill() {
    }

    public Bill(String articleDetail, int quantity, float subtotal, float total, String cashier, String date, String time) {
        this.billNumber = billNumber;
        this.articleDetail = articleDetail;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.total = total;
        this.cashier = cashier;
        this.date = date;
        this.time = time;
    }

    public long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(long billNumber) {
        this.billNumber = billNumber;
    }

    public String getArticleDetail() {
        return articleDetail;
    }

    public void setArticleDetail(String articleDetail) {
        this.articleDetail = articleDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
