package com.francisco.crud.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "`transaccionesBaratico`")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int transactionNumber;
    private Date date;
    private String time;

    public Transaction() {
    }

    public Transaction(long id, int transactionNumber, Date date, String time) {
        this.id = id;
        this.transactionNumber = transactionNumber;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
