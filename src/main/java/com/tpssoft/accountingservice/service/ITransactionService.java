package com.tpssoft.accountingservice.service;

import java.time.LocalDateTime;
import java.util.List;

import com.tpssoft.accountingservice.dto.TransactionDto;

public interface ITransactionService {

	boolean createTransaction(TransactionDto transaction);

	List<TransactionDto> getTransactionByTransactionDate(LocalDateTime start, LocalDateTime end, String walletId);

	List<TransactionDto> getTransactionByWalletId(String walletId);

}
