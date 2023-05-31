package com.tpssoft.accountingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpssoft.accountingservice.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
