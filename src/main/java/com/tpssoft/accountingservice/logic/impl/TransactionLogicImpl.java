package com.tpssoft.accountingservice.logic.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public boolean createTransaction(TransactionDto transactionDto) {

		String transactionId = transactionDto.getTransactionId();
		LocalDateTime transactionDate = transactionDto.getTransactionDate();
		double amount = transactionDto.getAmount();
		String category = transactionDto.getCategory();
		String status = transactionDto.getStatus();
		String cardId = transactionDto.getCardId();
		String walletId = transactionDto.getWalletId();
		String beneficiary = transactionDto.getBeneficiary();
		String remitter = transactionDto.getRemitter();
		double fee = transactionDto.getFee();

		Transaction transactionEntity = new Transaction();
		transactionEntity.setTransactionId(transactionId);
		transactionEntity.setAmount(amount);
		transactionEntity.setTransactionDate(transactionDate);
		transactionEntity.setCategory(category);
		transactionEntity.setStatus(status);
		transactionEntity.setCardId(cardId);
		transactionEntity.setWalletId(walletId);
		transactionEntity.setBeneficiary(beneficiary);
		transactionEntity.setRemitter(remitter);
		transactionEntity.setFee(fee);

		try {
			transactionRepository.save(transactionEntity);
			return true;
		} catch (IllegalArgumentException |  OptimisticLockingFailureException ex) {
			System.out.println(ex);

		}
		return false;

	}

	@Override
	public List<TransactionDto> getTransactionByWalletId(String walletId) {
		List<TransactionDto> ListTransactionDto = new ArrayList<>();
		for (Transaction transactionEntity : transactionRepository.getTransactionByWalletId(walletId)) {
			TransactionDto transactionDto = TransactionDto.builder()
					.transactionId(transactionEntity.getTransactionId())
					.amount(transactionEntity.getAmount())
					.fee(transactionEntity.getFee())
					.category(transactionEntity.getCategory())
					.beneficiary(transactionEntity.getBeneficiary())
					.remitter(transactionEntity.getRemitter())
					.status(transactionEntity.getStatus())
					.walletId(transactionEntity.getWalletId())
					.cardId(transactionEntity.getCardId())
					.transactionDate(transactionEntity.getTransactionDate())
					.build();
			ListTransactionDto.add(transactionDto);

		}
		return ListTransactionDto;

	}

	@Override
	public List<TransactionDto> getTransactionByTransactionDate(LocalDateTime start, LocalDateTime end, String walletId) {
		List<TransactionDto> ListTransactionDto = new ArrayList<>();
		for (Transaction transactionEntity : transactionRepository.getTransactionByTransactionDate(start, end, walletId)) {
			TransactionDto transactionDto = TransactionDto.builder()
					.transactionId(transactionEntity.getTransactionId())
					.amount(transactionEntity.getAmount())
					.fee(transactionEntity.getFee())
					.category(transactionEntity.getCategory())
					.beneficiary(transactionEntity.getBeneficiary())
					.remitter(transactionEntity.getRemitter())
					.status(transactionEntity.getStatus())
					.walletId(transactionEntity.getWalletId())
					.cardId(transactionEntity.getCardId())
					.transactionDate(transactionEntity.getTransactionDate())
					.build();
			ListTransactionDto.add(transactionDto);

		}
		return ListTransactionDto;
	}



}
