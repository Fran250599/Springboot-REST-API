package com.francisco.crud.repository;

import com.francisco.crud.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    Optional<Bill> findBillByBillNumber(Long billNumber);
}
