package com.tpssoft.accountingservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpssoft.accountingservice.dto.TransactionDto;
import com.tpssoft.accountingservice.logic.ITransactionLogic;
import com.tpssoft.accountingservice.service.ITransactionService;

@Service
public class TransactionServiceImpl implements ITransactionService {
	@Autowired
	ITransactionLogic transactionLogic;

	@Override
	public boolean createTransaction(TransactionDto transactionDto) {
		boolean result = transactionLogic.createTransaction(transactionDto);
		return result;
	}

	@Override
	public List<TransactionDto> getTransactionByWalletId(String walletId) {
		return transactionLogic.getTransactionByWalletId(walletId);
	}

	@Override
	public List<TransactionDto> getTransactionByTransactionDate(LocalDateTime start, LocalDateTime end, String walletId) {
		return transactionLogic.getTransactionByTransactionDate(start, end, walletId);
	}



}
