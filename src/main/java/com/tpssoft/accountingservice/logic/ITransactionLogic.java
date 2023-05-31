package com.tpssoft.accountingservice.logic;

import org.springframework.stereotype.Component;

import com.tpssoft.accountingservice.dto.TransactionDto;
import com.tpssoft.accountingservice.entity.Transaction;

@Component
public interface ITransactionLogic {
	public boolean createTransaction(TransactionDto transaction);

}
