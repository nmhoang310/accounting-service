package com.tpssoft.accountingservice.service;

import java.util.List;
import java.util.Optional;

import com.tpssoft.accountingservice.dto.TransactionDto;
import com.tpssoft.accountingservice.entity.Transaction;

public interface ITransactionService {

	boolean createTransaction(TransactionDto transaction);

}
