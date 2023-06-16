package com.tpssoft.accountingservice.logic;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tpssoft.accountingservice.dto.TransactionDto;

@Component
public interface ITransactionLogic {
	public boolean createTransaction(TransactionDto transaction);

	List<TransactionDto> getTransactionByTransactionDate(LocalDateTime start, LocalDateTime end, String walletId);

	List<TransactionDto> getTransactionByWalletId(String walletId);

}
