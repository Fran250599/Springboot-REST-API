package com.francisco.crud.model;

import jakarta.persistence.*;

import java.util.Date;

/*
* private long id;

    private int transactionNumber;
    private Date date;
    private String time;
    * */
@Entity
// Oracle friendly table with next fields: long id, int transactionNumber, Date date, String time
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int transactionNumber;
    private String fecha;
    private String time;

    public Transaction() {
    }

    public Transaction(long id, int transactionNumber, String date, String time) {
        this.id = id;
        this.transactionNumber = transactionNumber;
        this.fecha = fecha;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }


    public String getTime() {
        return time;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTime(String time) {
        this.time = time;
    }
}