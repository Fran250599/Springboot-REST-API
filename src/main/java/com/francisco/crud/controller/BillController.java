package com.francisco.crud.controller;


import com.francisco.crud.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.francisco.crud.service.BillService;

import java.util.List;

@RestController
@RequestMapping(path = "bills")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService = billService;
    }

    @GetMapping
    public List<Bill> getBills(){
        return billService.getBills();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") Long id){
        return billService.getBillById(id);
    }

    @PostMapping
    public ResponseEntity<Object> registerBill(@RequestBody Bill bill){
        return billService.newBill(bill);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateBill(@PathVariable("id") Long id, @RequestBody Bill bill){
        return billService.updateBill(id, bill);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteBill(@PathVariable("id") Long id){
        return billService.deleteBill(id);
    }



}
