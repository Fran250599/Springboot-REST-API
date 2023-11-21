package com.francisco.crud.model;

import jakarta.persistence.*;
import java.math.BigDecimal;


// Bill Entity for Oracle DB
@Entity
@Table(name = "BILL")
public class Bill {

    // Oracle friendly table with next fields: long id, String articleDetail, int quantity, BigDecimal subTotal, BigDecimal total, String cashier, String fecha, String hora
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String articleDetail;
    private int quantity;
    private BigDecimal subTotal;
    private BigDecimal total;
    private String cashier;
    private String fecha;
    private String hora;

    public Bill() {
    }

    public Bill(long id, String articleDetail, int quantity, BigDecimal subTotal, BigDecimal total, String cashier, String fecha, String hora) {
        this.id = id;
        this.articleDetail = articleDetail;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.total = total;
        this.cashier = cashier;
        this.fecha = fecha;
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}