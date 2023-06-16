package com.tpssoft.accountingservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tpssoft.accountingservice.entity.Transaction;;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{
	@Query("SELECT t FROM Transaction t WHERE t.walletId = ?1 ORDER BY t.transactionDate DESC")
	List<Transaction> getTransactionByWalletId(String walletId);

	@Query("SELECT t FROM Transaction t WHERE t.transactionDate >= ?1 AND t.transactionDate <= ?2 AND t.walletId = ?3 ORDER BY t.transactionDate DESC")
	List<Transaction> getTransactionByTransactionDate(LocalDateTime start, LocalDateTime end, String walletId);
}
