package com.francisco.crud.service;

import com.francisco.crud.model.Bill;
import com.francisco.crud.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @GetMapping
    public List<Bill> getBills(){
        return billRepository.findAll();
    }

    // Get product by id
    @GetMapping
    public ResponseEntity<Bill> getBillById(Long id) {

        Optional<Bill> res = billRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Dato encontrado:", res.get());
            data.put("Message", "Producto encontrado.");
            return ResponseEntity.ok(res.get());
        }

        data.put("Error", true);
        data.put("Message", "No existe un producto con este id.");
        return ResponseEntity.badRequest().body(res.get());
    }


    public ResponseEntity<Object> newBill(Bill bill){

        Optional<Bill> res = billRepository.findById(bill.getId());
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Error", true);
            data.put("Message", "Ya existe una factura con este número.");
            return ResponseEntity.badRequest().body(data);
        }

        billRepository.save(bill);

        data.put("Factura agregada", bill);
        data.put("Message", "Factura agregada correctamente.");
        return ResponseEntity.ok(data);
    }

    public ResponseEntity<Object> updateBill(Long id, Bill bill){

        Optional<Bill> res = billRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Factura actualizada", bill);
            data.put("Message", "Factura actualizada correctamente.");
            return ResponseEntity.ok(data);
        }

        data.put("Error", true);
        data.put("Message", "No existe una factura con este número.");
        return ResponseEntity.badRequest().body(data);
    }

    public ResponseEntity<Object> deleteBill(Long id){

        Optional<Bill> res = billRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Factura eliminada", res.get());
            data.put("Message", "Factura eliminada correctamente.");
            billRepository.deleteById(id);
            return ResponseEntity.ok(data);
        }

        data.put("Error", true);
        data.put("Message", "No existe una factura con este número.");
        return ResponseEntity.badRequest().body(data);
    }


}
