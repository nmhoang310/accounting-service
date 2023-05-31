package com.tpssoft.accountingservice.logic.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import com.tpssoft.accountingservice.dto.TransactionDto;
import com.tpssoft.accountingservice.entity.Transaction;
import com.tpssoft.accountingservice.logic.ITransactionLogic;
import com.tpssoft.accountingservice.repository.TransactionRepository;

@Component
public class TransactionLogicImpl implements ITransactionLogic {
	@Autowired
	TransactionRepository transactionRepository;
	
	public boolean createTransaction(TransactionDto transactionDto) {
		
		String transactionId = transactionDto.getTransactionId();
		LocalDateTime transactionDate = transactionDto.getTransactionDate();
		double amount = transactionDto.getAmount();
		String category = transactionDto.getCategory();
		String status = transactionDto.getStatus();
		String cardId = transactionDto.getCardId();
		String walletId = transactionDto.getWalletId();
		String remitter = transactionDto.getRemitter();
		String beneficiary = transactionDto.getBeneficiary();
		double fee = transactionDto.getFee();
		
		Transaction transactionEntity = new Transaction();
		transactionEntity.setTransactionId(transactionId);
		transactionEntity.setAmount(amount);
		transactionEntity.setTransactionDate(transactionDate);
		transactionEntity.setCategory(category);
		transactionEntity.setStatus(status);
		transactionEntity.setCardId(cardId);
		transactionEntity.setWalletId(walletId);
		transactionEntity.setRemitter(remitter);
		transactionEntity.setBeneficiary(beneficiary);
		transactionEntity.setFee(fee);
		
		try {
			transactionRepository.save(transactionEntity);
			return true;
		} catch (IllegalArgumentException |  OptimisticLockingFailureException ex) {
			System.out.println(ex);
			
		}
		return false;

	}
	
	
	
}
